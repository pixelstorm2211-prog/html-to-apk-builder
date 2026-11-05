# HTML to APK Builder

HTML is packaged inside an Android WebView app and built as a debug APK using GitHub Actions.

## One-button web builder

The browser UI is in `web/index.html`; its secure API proxy is in `worker/index.js`. The GitHub token must remain only in Cloudflare Worker Secrets.

### One-time setup

1. Create a **fine-grained personal access token** in GitHub, restricted to this repository only. Grant **Actions: Read and write** and **Metadata: Read-only**. Do not share the token or put it in website code.
2. Create a Cloudflare Worker named `html-to-apk-builder-api`; paste `worker/index.js` into its editor and deploy.
3. In Worker Settings → Variables and Secrets, add secret `GITHUB_TOKEN` with the token from step 1.
4. Add plain-text variable `ALLOWED_ORIGIN` with the exact Pages origin, e.g. `https://pixelstorm2211-prog.github.io`.
5. In GitHub Settings → Pages, choose Deploy from a branch, branch `main`, folder `/web`, and save.
6. Open the published Pages site, paste your Worker URL in the API field, and paste your HTML.

### Use

Click **СОЗДАТЬ APK**. The page triggers GitHub Actions, checks the build, and downloads the APK ZIP when ready. Unzip it to get `app-debug.apk`.

The APK is debug-signed for testing, not a Play Store release. Artifacts are retained for 14 days. HTML is passed as a workflow input and may appear in workflow metadata; do not include secrets or private data.

### Security

Keep `GITHUB_TOKEN` only in Cloudflare Worker Secrets. Never add it to `web/index.html`, query strings, or repository files. Configure Cloudflare rate limiting for the Worker; CORS is not authentication. Limit the token to this repository and the permissions above.
