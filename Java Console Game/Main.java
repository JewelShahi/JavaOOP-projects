import java.util.*;

class Main {

	public static void characters() {
		System.out.println("\nCharacters: Archer, Barbarian, Wizard");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("\n\nWelcome to the game!");

		byte n = 0;

		Archer a[] = new Archer[2];
		Barbarian b[] = new Barbarian[2];
		Wizard w[] = new Wizard[2];

		for (int i = 0; i < 2; i++) {
			a[i] = new Archer((byte) 100, (byte) 15);
			b[i] = new Barbarian((byte) 125, (byte) 10);
			w[i] = new Wizard((byte) 105, (byte) 25);
		}

		String oponent, you, youat, opat;
		while (!(((a[0].getHealth() <= 0 && b[0].getHealth() <= 0) || (a[0].getHealth() <= 0 && w[0].getHealth() <= 0)
				|| (w[0].getHealth() <= 0 && b[0].getHealth() <= 0))
				|| ((a[1].getHealth() <= 0 && b[1].getHealth() <= 0) || (a[1].getHealth() <= 0 && w[1].getHealth() <= 0)
						|| (w[1].getHealth() <= 0 && b[1].getHealth() <= 0)))) {
			characters();
			if (!((a[0].getHealth() <= 0 && b[0].getHealth() <= 0) || (a[0].getHealth() <= 0 && w[0].getHealth() <= 0)
					|| (w[0].getHealth() <= 0 && b[0].getHealth() <= 0))) {
				do {
					System.out.println("\nEnter a unit:(you)");
					you = scan.next();
				} while (!(you.equalsIgnoreCase("Archer") || you.equalsIgnoreCase("Barbarian")
						|| you.equalsIgnoreCase("Wizard")));
				do {
					System.out.println("Enter a unit to attack:(you)");
					youat = scan.next();
				} while (!(youat.equalsIgnoreCase("Archer") || youat.equalsIgnoreCase("Barbarian")
						|| youat.equalsIgnoreCase("Wizard")));
				if (you.equalsIgnoreCase("Archer") && youat.equalsIgnoreCase("Archer")) {
					if (a[1].getHealth() <= 0) {
						System.out.println("\nTry again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Barbarian") || youat.equalsIgnoreCase("Wizard")));
						if (youat.equalsIgnoreCase("Barbarian")) {
							b[1].setHealth((byte) (b[1].getHealth() - a[0].getAttack()));
							System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
						} else if (youat.equalsIgnoreCase("Wizard")) {
							w[1].setHealth((byte) (w[1].getHealth() - a[0].getAttack()));
							System.out.println("Opponet's wizard life is: " + w[1].getHealth());
						}
					} else if (!(a[1].getHealth() <= 0)) {
						a[1].setHealth((byte) (a[1].getHealth() - a[0].getAttack()));
						System.out.println("Opponet's archer life is: " + a[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Archer") && youat.equalsIgnoreCase("Barbarian")) {
					if (b[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Archer") || youat.equalsIgnoreCase("Wizard")));
						if (youat.equalsIgnoreCase("Archer")) {
							a[1].setHealth((byte) (a[1].getHealth() - a[0].getAttack()));
							System.out.println("Opponet's archer life is: " + a[1].getHealth());
						} else if (youat.equalsIgnoreCase("Wizard")) {
							w[1].setHealth((byte) (w[1].getHealth() - a[0].getAttack()));
							System.out.println("Opponet's wizard life is: " + w[1].getHealth());
						}
					} else if (!(b[1].getHealth() <= 0)) {
						b[1].setHealth((byte) (b[1].getHealth() - a[0].getAttack()));
						System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Archer") && youat.equalsIgnoreCase("Wizard")) {
					if (w[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Archer") || youat.equalsIgnoreCase("Barbarian")));
						if (youat.equalsIgnoreCase("Archer")) {
							a[1].setHealth((byte) (a[1].getHealth() - a[0].getAttack()));
							System.out.println("Opponet's archer life is: " + a[1].getHealth());
						} else if (youat.equalsIgnoreCase("Barbarian")) {
							b[1].setHealth((byte) (b[1].getHealth() - a[0].getAttack()));
							System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
						}
					} else if (!(w[1].getHealth() <= 0)) {
						w[1].setHealth((byte) (w[1].getHealth() - a[0].getAttack()));
						System.out.println("Opponet's wizard life is: " + w[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Barbarian") && youat.equalsIgnoreCase("Archer")) {
					if (a[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Wizard") || youat.equalsIgnoreCase("Barbarian")));
						if (youat.equalsIgnoreCase("Wizard")) {
							w[1].setHealth((byte) (w[1].getHealth() - b[0].getAttack()));
							System.out.println("Opponet's wizard life is: " + w[1].getHealth());
						} else if (youat.equalsIgnoreCase("Barbarian")) {
							b[1].setHealth((byte) (b[1].getHealth() - b[0].getAttack()));
							System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
						}
					} else if (!(a[1].getHealth() <= 0)) {
						a[1].setHealth((byte) (a[1].getHealth() - b[0].getAttack()));
						System.out.println("Opponet's archer life is: " + a[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Barbarian") && youat.equalsIgnoreCase("Barbarian")) {
					if (b[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Wizard") || youat.equalsIgnoreCase("Archer")));
						if (youat.equalsIgnoreCase("Wizard")) {
							w[1].setHealth((byte) (w[1].getHealth() - b[0].getAttack()));
							System.out.println("Opponet's wizard life is: " + w[1].getHealth());
						} else if (youat.equalsIgnoreCase("Archer")) {
							a[1].setHealth((byte) (a[1].getHealth() - b[0].getAttack()));
							System.out.println("Opponet's archer life is: " + b[1].getHealth());
						}
					} else if (!(b[1].getHealth() <= 0)) {
						b[1].setHealth((byte) (b[1].getHealth() - b[0].getAttack()));
						System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Barbarian") && youat.equalsIgnoreCase("Wizard")) {
					if (w[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Barbarian") || youat.equalsIgnoreCase("Archer")));
						if (youat.equalsIgnoreCase("Archer")) {
							a[1].setHealth((byte) (a[1].getHealth() - b[0].getAttack()));
							System.out.println("Opponet's archer life is: " + b[1].getHealth());
						} else if (youat.equalsIgnoreCase("Barbarian")) {
							b[1].setHealth((byte) (b[1].getHealth() - b[0].getAttack()));
							System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
						}
					} else if (!(w[1].getHealth() <= 0)) {
						w[1].setHealth((byte) (w[1].getHealth() - b[0].getAttack()));
						System.out.println("Opponet's wizard life is: " + w[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Wizard") && youat.equalsIgnoreCase("Archer")) {
					if (a[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Barbarian") || youat.equalsIgnoreCase("Wizard")));
						if (youat.equalsIgnoreCase("Barbarian")) {
							b[1].setHealth((byte) (b[1].getHealth() - w[0].getAttack()));
							System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
						} else if (youat.equalsIgnoreCase("Wizard")) {
							w[1].setHealth((byte) (w[1].getHealth() - w[0].getAttack()));
							System.out.println("Opponet's wizard life is: " + w[1].getHealth());
						}
					} else if (!(a[1].getHealth() <= 0)) {
						a[1].setHealth((byte) (a[1].getHealth() - w[0].getAttack()));
						System.out.println("Opponet's archer life is: " + a[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Wizard") && youat.equalsIgnoreCase("Barbarian")) {
					if (b[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Archer") || youat.equalsIgnoreCase("Wizard")));
						if (youat.equalsIgnoreCase("Archer")) {
							a[1].setHealth((byte) (a[1].getHealth() - w[0].getAttack()));
							System.out.println("Opponet's archer life is: " + a[1].getHealth());
						} else if (youat.equalsIgnoreCase("Wizard")) {
							w[1].setHealth((byte) (w[1].getHealth() - w[0].getAttack()));
							System.out.println("Opponet's wizard life is: " + w[1].getHealth());
						}
					} else if (!(b[1].getHealth() <= 0)) {
						b[1].setHealth((byte) (b[1].getHealth() - w[0].getAttack()));
						System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
					}
				} else if (you.equalsIgnoreCase("Wizard") && youat.equalsIgnoreCase("Wizard")) {
					if (w[1].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(you)");
							youat = scan.next();
						} while (!(youat.equalsIgnoreCase("Archer") || youat.equalsIgnoreCase("Barbarian")));
						if (youat.equalsIgnoreCase("Archer")) {
							a[1].setHealth((byte) (a[1].getHealth() - w[0].getAttack()));
							System.out.println("Opponet's archer life is: " + a[1].getHealth());
						} else if (youat.equalsIgnoreCase("Barbarian")) {
							b[1].setHealth((byte) (b[1].getHealth() - w[0].getAttack()));
							System.out.println("Opponet's barbarian life is: " + b[1].getHealth());
						}
					} else if ((w[1].getHealth() <= 0)) {
						w[1].setHealth((byte) (w[1].getHealth() - w[0].getAttack()));
						System.out.println("Opponet's wizard life is: " + w[1].getHealth());
					}
				}
				if (a[1].getHealth() <= 0) {
					a[1].setHealth(n);
					a[1].setAttack(n);
				}
				if (b[1].getHealth() <= 0) {
					b[1].setHealth(n);
					b[1].setAttack(n);
				}
				if (w[1].getHealth() <= 0) {
					w[1].setHealth(n);
					w[1].setAttack(n);
				}
			} else {
				break;
			}
			if (!((a[1].getHealth() <= 0 && b[1].getHealth() <= 0) || (a[1].getHealth() <= 0 && w[1].getHealth() <= 0)
					|| (w[1].getHealth() <= 0 && b[1].getHealth() <= 0))) {
				do {
					System.out.println("\nEnter a unit:(op)");
					oponent = scan.next();
				} while (!(oponent.equalsIgnoreCase("Archer") || oponent.equalsIgnoreCase("Barbarian")
						|| oponent.equalsIgnoreCase("Wizard")));
				do {
					System.out.println("Enter a unit to attack:(op)");
					opat = scan.next();
				} while (!(opat.equalsIgnoreCase("Archer") || opat.equalsIgnoreCase("Barbarian")
						|| opat.equalsIgnoreCase("Wizard")));
				if (oponent.equalsIgnoreCase("Archer") && opat.equalsIgnoreCase("Archer")) {
					if (a[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Wizard") || opat.equalsIgnoreCase("Barbarian")));
						if (opat.equalsIgnoreCase("Barbarian")) {
							b[0].setHealth((byte) (b[0].getHealth() - a[1].getAttack()));
							System.out.println("Your barbarian life is: " + b[0].getHealth());
						} else if (opat.equalsIgnoreCase("Wizard")) {
							w[0].setHealth((byte) (w[0].getHealth() - a[1].getAttack()));
							System.out.println("Your wizard life is: " + w[0].getHealth());
						}
					} else if (!(a[0].getHealth() <= 0)) {
						a[0].setHealth((byte) (a[0].getHealth() - a[1].getAttack()));
						System.out.println("Your archer life is: " + a[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Archer") && opat.equalsIgnoreCase("Barbarian")) {
					if (b[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Wizard") || opat.equalsIgnoreCase("Archer")));
						if (opat.equalsIgnoreCase("Wizard")) {
							w[0].setHealth((byte) (w[0].getHealth() - a[1].getAttack()));
							System.out.println("Your wizard life is: " + w[0].getHealth());
						} else if (opat.equalsIgnoreCase("Archer")) {
							a[0].setHealth((byte) (a[0].getHealth() - a[1].getAttack()));
							System.out.println("Your archer life is: " + a[0].getHealth());
						}
					} else if (!(b[0].getHealth() <= 0)) {
						b[0].setHealth((byte) (b[0].getHealth() - a[1].getAttack()));
						System.out.println("Your barbarian life is: " + b[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Archer") && opat.equalsIgnoreCase("Wizard")) {
					if (w[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Barbarian") || opat.equalsIgnoreCase("Archer")));
						if (opat.equalsIgnoreCase("Archer")) {
							a[0].setHealth((byte) (a[0].getHealth() - a[1].getAttack()));
							System.out.println("Your archer life is: " + a[0].getHealth());
						} else if (opat.equalsIgnoreCase("Barbarian")) {
							b[0].setHealth((byte) (b[0].getHealth() - a[1].getAttack()));
							System.out.println("Your barbarian life is: " + b[0].getHealth());
						}
					} else if (!(w[0].getHealth() <= 0)) {
						w[0].setHealth((byte) (w[0].getHealth() - a[1].getAttack()));
						System.out.println("Your wizard life is: " + w[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Barbarian") && opat.equalsIgnoreCase("Archer")) {
					if (a[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Barbarian") || opat.equalsIgnoreCase("Wizard")));
						if (opat.equalsIgnoreCase("Barbarian")) {
							b[0].setHealth((byte) (b[0].getHealth() - b[1].getAttack()));
							System.out.println("Your barbarian life is: " + b[0].getHealth());
						} else if (opat.equalsIgnoreCase("Wizard")) {
							w[0].setHealth((byte) (w[0].getHealth() - b[1].getAttack()));
							System.out.println("Your wizard life is: " + w[0].getHealth());
						}
					} else if (!(a[0].getHealth() <= 0)) {
						a[0].setHealth((byte) (a[0].getHealth() - b[1].getAttack()));
						System.out.println("Your archer life is: " + a[0].getHealth());
					}
				}
				// work here
				else if (oponent.equalsIgnoreCase("Barbarian") && opat.equalsIgnoreCase("Barbarian")) {
					if (b[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Archer") || opat.equalsIgnoreCase("Wizard")));
						if (opat.equalsIgnoreCase("Archer")) {
							a[0].setHealth((byte) (a[0].getHealth() - b[1].getAttack()));
							System.out.println("Your archer life is: " + a[0].getHealth());
						} else if (opat.equalsIgnoreCase("Wizard")) {
							w[0].setHealth((byte) (w[0].getHealth() - b[1].getAttack()));
							System.out.println("Your wizard life is: " + w[0].getHealth());
						}
					} else if (!(b[0].getHealth() <= 0)) {
						b[0].setHealth((byte) (b[0].getHealth() - b[1].getAttack()));
						System.out.println("Your barbarian life is: " + b[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Barbarian") && opat.equalsIgnoreCase("Wizard")) {
					if (w[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Archer") || opat.equalsIgnoreCase("Barbarian")));
						if (opat.equalsIgnoreCase("Archer")) {
							a[0].setHealth((byte) (a[0].getHealth() - b[1].getAttack()));
							System.out.println("Your archer life is: " + a[0].getHealth());
						} else if (opat.equalsIgnoreCase("barbarian")) {
							b[0].setHealth((byte) (b[0].getHealth() - b[1].getAttack()));
							System.out.println("Your barbarian life is: " + b[0].getHealth());
						}
					} else if (!(w[0].getHealth() <= 0)) {
						w[0].setHealth((byte) (w[0].getHealth() - b[1].getAttack()));
						System.out.println("Your wizard life is: " + w[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Wizard") && opat.equalsIgnoreCase("Archer")) {
					if (a[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Wizard") || opat.equalsIgnoreCase("Barbarian")));
						if (opat.equalsIgnoreCase("Barbarian")) {
							b[0].setHealth((byte) (b[0].getHealth() - w[1].getAttack()));
							System.out.println("Your barbarian life is: " + b[0].getHealth());
						} else if (opat.equalsIgnoreCase("Wizard")) {
							w[0].setHealth((byte) (w[0].getHealth() - w[1].getAttack()));
							System.out.println("Your wizard life is: " + w[0].getHealth());
						}
					} else if (!(a[0].getHealth() <= 0)) {
						a[0].setHealth((byte) (a[0].getHealth() - w[1].getAttack()));
						System.out.println("Your archer life is: " + a[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Wizard") && opat.equalsIgnoreCase("Barbarian")) {
					if (b[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Wizard") || opat.equalsIgnoreCase("Archer")));
						if (opat.equalsIgnoreCase("Archer")) {
							a[0].setHealth((byte) (a[0].getHealth() - w[1].getAttack()));
							System.out.println("Your archer life is: " + a[0].getHealth());
						} else if (opat.equalsIgnoreCase("Wizard")) {
							w[0].setHealth((byte) (w[0].getHealth() - w[1].getAttack()));
							System.out.println("Your wizard life is: " + w[0].getHealth());
						}
					} else if (!(b[0].getHealth() <= 0)) {
						b[0].setHealth((byte) (b[0].getHealth() - w[1].getAttack()));
						System.out.println("Your barbarian life is: " + b[0].getHealth());
					}
				} else if (oponent.equalsIgnoreCase("Wizard") && opat.equalsIgnoreCase("Wizard")) {
					if (w[0].getHealth() <= 0) {
						System.out.println("Try again!\n");
						do {
							System.out.println("Enter a unit to attack:(op)");
							opat = scan.next();
						} while (!(opat.equalsIgnoreCase("Barbarian") || opat.equalsIgnoreCase("Archer")));
						if (opat.equalsIgnoreCase("Archer")) {
							a[0].setHealth((byte) (a[0].getHealth() - w[1].getAttack()));
							System.out.println("Your archer life is: " + a[0].getHealth());
						} else if (opat.equalsIgnoreCase("Barbarian")) {
							b[0].setHealth((byte) (b[0].getHealth() - w[1].getAttack()));
							System.out.println("Your barbarian life is: " + b[0].getHealth());
						}
					} else if (!(w[0].getHealth() <= 0)) {
						w[0].setHealth((byte) (w[0].getHealth() - w[1].getAttack()));
						System.out.println("Your wizard life is: " + w[0].getHealth());
					}
				}
				if (a[0].getHealth() <= 0) {
					a[0].setHealth(n);
					a[0].setAttack(n);
				}
				if (b[0].getHealth() <= 0) {
					b[0].setHealth(n);
					b[0].setAttack(n);
				}
				if (w[0].getHealth() <= 0) {
					w[0].setHealth(n);
					w[0].setAttack(n);
				}
			} else {
				break;
			}
		}
		if ((a[0].getHealth() <= 0 && b[0].getHealth() <= 0) || (a[0].getHealth() <= 0 && w[0].getHealth() <= 0)
				|| (w[0].getHealth() <= 0 && b[0].getHealth() <= 0)) {
			System.out.println("\n\nOpponet won!\n\n");
		} else if ((a[1].getHealth() <= 0 && b[1].getHealth() <= 0) || (a[1].getHealth() <= 0 && w[1].getHealth() <= 0)
				|| (w[1].getHealth() <= 0 && b[1].getHealth() <= 0)) {
			System.out.println("\n\nYou won!\n\n");
		}

		scan.close();
	}
}
