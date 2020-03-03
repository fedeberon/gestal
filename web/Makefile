default:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
dist: ## Package project with maven tool.
	mvn clean package
image: ## Build docker image (version is always latest).
	docker build -t gestal:latest .
run: ## Run docker image
	docker run gestal:latest
run-bash: ## Run container's bash.
	docker run -i -t gestal:latest /bin/bash
up: dist image run ## Package project, build image and run container.
rm-img:
	docker rmi $(docker images | grep "<none>" | awk "{print $3}")