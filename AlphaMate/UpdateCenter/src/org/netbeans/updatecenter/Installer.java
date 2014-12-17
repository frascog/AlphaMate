/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.updatecenter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.swing.SwingUtilities;
import org.netbeans.api.autoupdate.InstallSupport;
import org.netbeans.api.autoupdate.InstallSupport.Validator;
import org.netbeans.api.autoupdate.OperationContainer;
import org.netbeans.api.autoupdate.OperationContainer.OperationInfo;
import org.netbeans.api.autoupdate.OperationException;
import org.netbeans.api.autoupdate.OperationSupport.Restarter;
import org.netbeans.api.autoupdate.UpdateElement;
import org.netbeans.api.autoupdate.UpdateManager;
import org.netbeans.api.autoupdate.UpdateUnit;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.modules.ModuleInstall;
import org.openide.util.RequestProcessor;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        // schedule refresh providers
        // install update checker when UI is ready (main window shown)
        WindowManager.getDefault().invokeWhenUIReady(new Runnable() {
            public void run() {
                RequestProcessor.getDefault().post(doCheck, 10000);
            }
        });
    }

    private static Runnable doCheck = new Runnable() {
        public void run() {
            if (SwingUtilities.isEventDispatchThread()) {
                RequestProcessor.getDefault().post(doCheck);
                return;
            }
            doRealCheck();
        }
    };

    public static Collection<UpdateElement> doRealCheck() {
        Collection<UpdateElement> elements4update = new HashSet<UpdateElement>();
        List<UpdateUnit> updateUnits = UpdateManager.getDefault().getUpdateUnits();
        for (UpdateUnit unit : updateUnits) {
            if (unit.getInstalled() != null) { // means the plugin already installed
                if (!unit.getAvailableUpdates().isEmpty()) { // has updates
                    elements4update.add(unit.getAvailableUpdates().get(0)); // add plugin with highest version
                }
            }
        }
        return elements4update;
    }

    public OperationContainer<InstallSupport> getContainerForUpdate(Collection<UpdateElement> elements4update) {
        OperationContainer<InstallSupport> container = OperationContainer.createForUpdate();
        for (UpdateElement element : elements4update) {
            if (container.canBeAdded(element.getUpdateUnit(), element)) {
                OperationInfo<InstallSupport> operationInfo = container.add(element);
                if (operationInfo == null) {
                    continue;
                }
                container.add(operationInfo.getRequiredElements());
            }
        }
        return container;
    }

    public boolean allLicensesApproved(OperationContainer<InstallSupport> container) {
        if (!container.listInvalid().isEmpty()) {
            return false;
        }
        for (OperationInfo<InstallSupport> info : container.listAll()) {
            String license = info.getUpdateElement().getLicence();
            if (!isLicenseApproved(license)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLicenseApproved(String license) {
        // place your code there
        return true;
    }

    public Validator doDownload(OperationContainer<InstallSupport> container) throws OperationException {
        InstallSupport install = container.getSupport();
        ProgressHandle downloadHandle = ProgressHandleFactory.createHandle("dummy-download-handle");
        return install.doDownload(downloadHandle, true);
    }

    public Restarter doInstall(InstallSupport support, Validator validator) throws OperationException {
        ProgressHandle validateHandle = ProgressHandleFactory.createHandle("dummy-validate-handle");
        InstallSupport.Installer installer = support.doValidate(validator, validateHandle); // validates all plugins are correctly downloaded
        ProgressHandle installHandle = ProgressHandleFactory.createHandle("dummy-install-handle");
        return support.doInstall(installer, installHandle);
    }

    public void doRestartLater(InstallSupport support, Restarter restarter) {
        support.doRestartLater(restarter);
    }

    public void doRestartNow(InstallSupport support, Restarter restarter) throws OperationException {
        ProgressHandle installHandle = ProgressHandleFactory.createHandle("dummy-install-handle");
        support.doRestart(restarter, installHandle);
    }
}
