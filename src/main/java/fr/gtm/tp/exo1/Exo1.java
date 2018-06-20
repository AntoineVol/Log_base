package fr.gtm.tp.exo1;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exo1 implements Runnable {
	private final String username;
	private static final Logger LOGGER = LoggerFactory.getLogger(Exo1.class);

	public Exo1(final String[] args) {
		if (args.length > 0) {
			this.username = args[0];
		} else {
			this.username = null;
			LOGGER.error(
					"Impossible d'executer l'application, veuillez renseigner un argument au lancement de l'application");
			this.usage();
			System.exit(1);
		}
	}

	private void usage() {
		LOGGER.info("USAGE : exo1 <username>");
		LOGGER.info("\t-username: Votre pseudo");
	}

	public static void main(String[] args) {
		new Exo1(args).run();

	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		LOGGER.info("Lancement de l'inplication par {}", this.username);

		do {
			try {
				System.out.print("Veuillez reseigner un nombre entier à tester :");
				str = sc.nextLine();
				if (!(str.equals("exit"))) {
					int nb = Integer.parseInt(str);
					if (nb > 0) {
						System.out.print(nb + " est un entier positif");
					} else if (nb == 0) {
						System.out.print(nb + " est null");
					} else {
						System.out.print(nb + " est un entier negatif");
					}
					if (nb % 2 == 0) {
						System.out.println(" et est pair\n");
					} else {
						System.out.println(" et est impaire\n");
					}
				}
			} catch (NumberFormatException e) {
				LOGGER.error("Seuls les entiers ou la valeur -exit- sont authorisés");
				continue;
			}
		} while (!str.equals("exit"));

	}
}
