# HTML to APK Builder

This repository packages a supplied HTML page inside an Android WebView app and builds an installable **debug APK** using GitHub Actions.

## Build an APK

1. Open the **Actions** tab in this repository.
2. Select **Build Android APK**.
3. Click **Run workflow**.
4. Enter the app name and paste the complete HTML source into **html_content** (up to 65,000 characters).
5. Start the workflow and wait for it to finish.
6. Open the completed run, find **Artifacts**, and download **html-android-apk**. Unzip it to get `app-debug.apk`.

The APK is debug-signed by the Android Gradle Plugin and can be installed for testing. Android may ask you to allow installation from the browser or file manager. This is not a Play Store release; a production release needs a private signing key and release configuration.

## Notes

- The app displays the supplied page locally in Android WebView.
- JavaScript and DOM storage are enabled.
- Remote resources need an internet connection.
- The workflow runs only when manually started. It does not expose a public build server or store GitHub credentials in a web page.
