package hello

import "testing"

func TestHello(t *testing.T) {
	got := HelloWorld()
	want := "Hello, world!"
	if got != want {
		t.Errorf("Expected %q but got %q", want, got)
	}
}
