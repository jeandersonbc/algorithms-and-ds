.PHONY: all tests

all: codestyle typecheck tests

codestyle:
	@echo Running codestyle
	uv run ruff format .
	uv run ruff check --fix .

typecheck:
	@echo Running typecheck 
	uv run mypy .

tests:
	@echo Running tests
	uv run pytest

