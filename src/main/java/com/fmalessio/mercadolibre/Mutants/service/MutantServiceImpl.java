package com.fmalessio.mercadolibre.Mutants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmalessio.mercadolibre.Mutants.entity.Dna;
import com.fmalessio.mercadolibre.Mutants.repository.DnaRepository;

@Service
public class MutantServiceImpl implements MutantService {

	@Autowired
	private DnaRepository dnaRepository;

	public boolean isMutant(String[] dna) {
		int dnaSameSequenceCounter = checkFrontDirectionDnaWrapper(dna) + checkDownDirectionDna(dna)
				+ checkDiagonalDownDirectionDna(dna) + checkDiagonalUpDirectionDna(dna);

		boolean isMutant = dnaSameSequenceCounter > 1;
		Dna dnaEntity = new Dna(dna, isMutant);

		dnaRepository.save(dnaEntity);

		return isMutant;
	}

	/**
	 * Diagonal up
	 */
	// i = chains/rows. j = letters. k = next positions.
	private int checkDiagonalUpDirectionDna(String[] dna) {
		int dnaSameSequence = 0;

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
					dnaSameSequence++;
				}

			}
		}

		return dnaSameSequence;
	}

	/**
	 * Diagonal down
	 */
	private int checkDiagonalDownDirectionDna(String[] dna) {
		int dnaSameSequence = 0;

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
					dnaSameSequence++;
				}

			}
		}

		return dnaSameSequence;
	}

	/**
	 * Down
	 */
	private int checkDownDirectionDna(String[] dna) {
		int dnaSameSequence = 0;

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
					dnaSameSequence++;
				}

			}
		}

		return dnaSameSequence;
	}

	/**
	 * Front
	 */
	private int checkFrontDirectionDnaWrapper(String[] dna) {
		int dnaSameSequence = 0;

		for (int i = 0; i < dna.length; i++) {
			dnaSameSequence += checkFrontDirectionDna(dna[i]);
		}

		return dnaSameSequence;
	}

	private int checkFrontDirectionDna(String chain) {
		int dnaSameSequence = 0;

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
				dnaSameSequence++;
			}
		}

		return dnaSameSequence;
	}

	public static boolean isValidDna(String[] dna) {
		return true;
	}

}
