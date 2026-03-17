from algs.hello import hello


def test_has_hello_message() -> None:
    assert hello() == "Hello, world!"
