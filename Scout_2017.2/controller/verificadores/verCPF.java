package controller.verificadores;

import java.util.stream.IntStream;

public class verCPF {

	private static final int CPF_SIZE = 11;

	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || !cpf.matches("^(\\d){11}$") || cpf.matches("^(\\d)\\1+{11}$"))
			return false;

		int[] digits = cpf.chars().map(c -> c - '0').toArray();

		int digitsValidator = calculateDigitsValidator(digits, 9);

		if (digitsValidator != digits[9])
			return false;

		digitsValidator = calculateDigitsValidator(digits, 10);

		return (digitsValidator == digits[10]);
	}

	private static int calculateDigitsValidator(int[] cpf, int endIndex) {

		int digit = IntStream.range(0, endIndex).map(i -> cpf[i] * (endIndex + 1 - i)).sum();
		digit = CPF_SIZE - (digit % 11);
		return (digit > 9) ? 0 : digit;
	}
}
