# PromptPilot

A lightweight web app for scheduling AI prompts in the browser.

## Features

- Create daily, weekday, weekly, or one-time prompts
- Store schedules and results in browser localStorage
- Optional OpenAI Responses API integration
- Browser notifications
- Responsive dark UI

## Run

Open `index.html` directly or publish the repository with GitHub Pages.

## OpenAI key

For the prototype, the key is kept in the browser's local storage. Open the browser developer console and run:

```js
localStorage.setItem('promptpilot_openai_key', 'YOUR_OPENAI_API_KEY')
```

Never use this client-side key approach for a public production application. A production version should put the OpenAI API call behind a server/serverless function and keep the API key in a secret.

## Scheduling note

This version is a browser scheduler: the page needs to be open for the scheduled JavaScript timer to run. GitHub Actions supports cron-based scheduled workflows, including timezone-aware schedules, but a multi-user scheduling product needs a backend or another persistent scheduler to dynamically manage each user's jobs.
