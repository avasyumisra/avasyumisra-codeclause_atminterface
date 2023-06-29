<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>ATM-Machine</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
</projectDescription>
 16 changes: 10 additions & 6 deletions16  
ATM/ATM.java
@@ -1,10 +1,14 @@
import java.io.IOException;
public class ATM extends OptionMenu{

  public static void main(String[] args) throws IOException {
    OptionMenu optionMenu= new OptionMenu();
public class ATM extends OptionMenu {

    optionMenu.getLogin();
  }
	public static void main(String[] args) throws IOException {
		OptionMenu optionMenu = new OptionMenu();
		introduction();
		optionMenu.mainMenu();
	}

};
	public static void introduction() {
		System.out.println("Welcome to the ATM Project!");
	}
}
