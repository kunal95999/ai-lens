# AI Lens — Dev Log

Daily progress log for the AI Lens project.
Multi-model AI vision search — browser extension + Spring Boot gateway.

---

## Day 1 — 23 May 2026
**Goal:** Project bootstrapping and core skeleton setup

**Done:**
- Initialized Spring Boot 3.3.5 project with Maven
- Set up package structure (controller, service, strategy, model, config, exception)
- Configured pom.xml with WebClient, Redis, PostgreSQL, Lombok
- Fixed nested folder structure and git repo issues
- Connected local repo to GitHub

---

## Day 2 — 23 May 2026
**Goal:** Build core skeleton and verify app starts

**Done:**
- Created LensRequest, LensResponse model classes
- Defined ModelStrategy interface (Strategy pattern foundation)
- Built ModelRouterService — auto-discovers strategy beans via Spring DI
- Created LensController with /analyze and /models endpoints
- Configured application.yml with env-variable-based AI provider configs
- Fixed Lombok annotation processing in IntelliJ
- App starts cleanly on port 8080, /api/lens/models returns []

**Next:**
- Azure AI Foundry setup — deploy GPT-4o, Deepseek, Llama, Phi
- Implement GptVisionStrategy — first real AI call

---