package com.fmalessio.mercadolibre.Mutants.service;

import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

	public boolean isMutant(String[] dna) {
		return checkFrontDirectionDnaWrapper(dna) || checkDownDirectionDna(dna) || checkDiagonalDownDirectionDna(dna)
				|| checkDiagonalUpDirectionDna(dna);
	}

	/**
	 * Diagonal up
	 */
	// i = chains/rows. j = letters. k = next positions.
	private boolean checkDiagonalUpDirectionDna(String[] dna) {
		// Ex. 6x6 = Check from the fourth
		for (int i = dna.length - 3; i < dna.length; i++) {
			String[] letters = dna[i].split("");

			// For each letter - last 3 (top diagonal)
			for (int j = 0; j < letters.length - 3; j++) {
				String letter = letters[j];

				int k = i - 1;
				int count = 1;
				while (count < 4) {
					String diagonalDown = String.valueOf(dna[k].charAt(j + count));
					if (letter.equals(diagonalDown)) {
						count++;
					} else {
						break;
					}
					k--;
				}

				if (count == 4) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Diagonal down
	 */
	private boolean checkDiagonalDownDirectionDna(String[] dna) {
		// Ex. 6x6 = First 3 chains
		for (int i = 0; i < dna.length - 3; i++) {
			String[] letters = dna[i].split("");

			// For each letter - last 3 (top diagonal)
			for (int j = 0; j < letters.length - 3; j++) {
				String letter = letters[j];

				int k = i + 1;
				int count = 1;
				while (count < 4) {
					String diagonalDown = String.valueOf(dna[k].charAt(j + count));
					if (letter.equals(diagonalDown)) {
						count++;
					} else {
						break;
					}
					k++;
				}

				if (count == 4) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Down
	 */
	private boolean checkDownDirectionDna(String[] dna) {
		// Ex. 6x6 = First 3 chains
		for (int i = 0; i < dna.length - 3; i++) {
			String[] letters = dna[i].split("");

			// For each letter
			for (int j = 0; j < letters.length; j++) {
				String letter = letters[j];

				int k = i + 1;
				int count = 1;
				while (count < 4) {
					String down = String.valueOf(dna[k].charAt(j));
					if (letter.equals(down)) {
						count++;
					} else {
						break;
					}
					k++;
				}

				if (count == 4) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Front
	 */
	private boolean checkFrontDirectionDnaWrapper(String[] dna) {
		boolean isMutant = false;

		for (int i = 0; i < dna.length && !isMutant; i++) {
			isMutant = checkFrontDirectionDna(dna[i]);
		}

		return isMutant;
	}

	private boolean checkFrontDirectionDna(String chain) {
		String letter = "";
		// Ex. 6x6 = First 3 letter positions
		for (int i = 0; i < chain.length() - 3; i++) {
			letter = String.valueOf(chain.charAt(i));

			int j = i + 1;
			int count = 1;
			while (count < 4) {
				if (letter.equals(String.valueOf(chain.charAt(j)))) {
					count++;
				} else {
					break;
				}
				j++;
			}

			if (count == 4) {
				return true;
			}
		}

		return false;
	}

	public static boolean isValidDna(String[] dna) {
		return true;
	}

}
