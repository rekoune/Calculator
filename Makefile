SRC = Calculator.java Main.java MyButtons.java MyWindow.java
CLFL = $(SRC:.java=.class)
CC = javac

all: compiling

compiling: 
	@$(CC) $(SRC)

run : all
	@java  Main

clean :
	@rm -rf $(CLFL)