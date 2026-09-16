# Event Intelligence Lab

A local-first event intelligence workbench for turning raw events into timelines, correlations, patterns, alerts, and explainable observations.

## Why this exists

The current `alazar80` portfolio contains many application-specific projects, but it does not have a reusable, domain-neutral event intelligence core. This project fills that gap without requiring a cloud service or API key.

## Capabilities

- Import JSON event streams
- Normalize events into a common schema
- Sort and filter by time, source, type, and severity
- Detect repeated event patterns
- Correlate events occurring within a configurable time window
- Produce explainable observations instead of opaque scores
- Export the current analysis as JSON
- Run entirely in the browser with no backend

## Event model

Each event can contain:

`id`, `timestamp`, `source`, `type`, `severity`, `entity`, `action`, `value`, `unit`, and arbitrary `metadata`.

## Run

Open `index.html` directly, or publish this directory with GitHub Pages.

## Design direction

The engine is intentionally domain-neutral. The same primitives can represent software logs, sensor observations, manufacturing events, financial transactions, user interactions, scientific measurements, or other timestamped data.

## Safety and privacy

No event data leaves the browser. This prototype has no analytics endpoint and no remote API dependency.
