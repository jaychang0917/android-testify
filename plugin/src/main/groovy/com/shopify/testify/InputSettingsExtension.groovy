package com.shopify.testify

import org.gradle.api.Project

class InputSettingsExtension {
    String applicationPackageId
    String testPackageId
    long pullWaitTime = 0
    String testRunner
    String baselineSourceDir
    String moduleName;
    String testContextId

    String getTestRunner() {
        if (testRunner == null) {
            testRunner = "android.support.test.runner.AndroidJUnitRunner"
        }
        return testRunner
    }

    String getTestContextId() {
        if (testContextId == null) {
            testContextId = getTestPackageId()
        }
        return testContextId
    }

    String getTestPackageId() {
        if (testPackageId == null) {
            return "${applicationPackageId}.test"
        }
        return testPackageId
    }

    static void validate(Project project) {
        InputSettingsExtension extension = project.getExtensions().findByType(InputSettingsExtension)
        if (extension == null || extension.applicationPackageId == null) {
            throw new Exception("You must define a `testify` extension block in your build.gradle")
        }
    }
}
