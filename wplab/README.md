# wplab — Web Technologies Lab (based on manual code)

Each week's code is taken from the lab manual, with bugs fixed so it actually runs, plus small color/font touches (not a full redesign).

## Week 1 — Home Page (frameset) & Login Page
Files: `home.html`, `frame1.html`, `frame2.html`, `frame3.html`, `login.html`, `logo.png`, `agicover.jpg`
- Open `home.html` (NOT the individual frame files) — it stitches the 3 frames together.
- Fixed: manual referenced `logo.png` and `agicover copy.jpg` that don't exist on disk — replaced with real placeholder images so nothing shows a broken-image icon.
- Color changed from plain pink to a blue/lavender theme; added a readable font-family.

## Week 2 — Registration Page
File: `registration.html`
- Fixed: manual had a `<form>` tag illegally opened *inside* a `<tr>` (invalid HTML — browsers silently move it, breaking the form). Wrapped the whole table in one single `<form>` instead.
- Fixed: a missing `</tr>` after the Date-of-Birth row.
- Color changed to a light lavender theme.

## Week 3 — Internal + External CSS (Student Result Analysis)
Files: `result.html`, `Ex.css`
- Fixed: the manual's CSS had `background: black; color: black;` — text would've been invisible. Changed to a readable light-blue/dark-text theme.
- Fixed: a JS bug where the "Fail" case set a variable `Grade` (capital G) instead of `grade` (lowercase) — so the grade box stayed blank on a Fail. Corrected the capitalization.
- Fixed: a stray unclosed `<h1>` tag in the manual's table cell — removed.

## Week 4 — JavaScript Validation
Files: `registration_validation.html`, `Login.html`
- Kept the manual's validation functions (name, password, email, phone) as-is — logic unchanged.
- Added `Login.html` as a placeholder landing page, since the form's `action="Login.html"` pointed to a file that didn't exist in the manual's own folder (would 404 on submit).
- Color changed to a soft red/pink theme.

## Week 5 — Catalogue / Cart Page
File: `cart.html`
- Fixed: the manual never closed the `</table>` tag.
- Color changed to a light green theme; header row shaded for readability.

## Week 6 — XML + DTD
Files: `library.xml`, `library.dtd`
- Fixed: the manual's `.dtd` file mistakenly started with an XML declaration (`<?xml version=...?>`) — that syntax doesn't belong in a `.dtd` file at all. Removed it.
- Fixed: `<! ELEMENT library (book+)>` had a stray space — DTD syntax requires `<!ELEMENT` with no space.
- Fixed: the XML's `DOCTYPE` pointed to a hardcoded Windows path (`C:\Users\akshay\...`) that only existed on the manual writer's PC. Changed to a relative `"library.dtd"` so it resolves correctly wherever the folder is opened.
- Validated: `xmllint --noout --valid library.xml` passes with zero errors.

## Week 7 — Bootstrap
File: `bootstrap.html`
- Fixed: the manual linked local files `css/bootstrap.min.css` and `js/bootstrap.min.js` that don't exist in the folder — switched both to CDN links (Bootstrap 3.4.1, matching the manual's `panel`/`navbar-inverse` classes, which are Bootstrap 3 syntax).
- Fixed: a missing opening quote in the manual's script tag (`<script src=js/bootstrap.min.js" >`) — corrected.
- Fixed: the "Password" input field used `type="text"` in the manual (would show the password in plain text) — changed to `type="password"`.
- Fixed: two elements shared the same `id="basic-addon1"` (invalid — IDs must be unique) — gave the second one a distinct ID.
- Needs internet access to load Bootstrap/jQuery from CDN.

## How to run
Open any `.html` file directly in a browser, or right-click → **Open with Live Server** in VS Code.

## Push to GitHub
```bash
cd wplab
git init
git add .
git commit -m "Web Technologies lab week 1-7"
git branch -M main
git remote add origin https://github.com/<your-username>/wplab.git
git push -u origin main
```
