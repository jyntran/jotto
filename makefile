# super simple makefile
# call it using 'make NAME=name_of_code_file_without_extension'
# (assumes a .java extension)
NAME = "Main"

all:
	@echo "Compiling..."
	javac jotto/*.java

run: all
	@echo "Running..."
	java jotto/$(NAME)

clean:
	rm -rf *.class
