// Java Solutions to 3 HackerEarth Problems with comments
// Author: André Nicoletti

import java.io.*;
import java.util.*;

public class TestClass {

    // ---------- MAIN DE TESTE ----------
    public static void main(String[] args) {
        // Problema 1: Reserva de assentos
        int[] seatOps = {0, 0, 0, 2, 0};
        int[] reservedSeats = solution1(3, seatOps.length, seatOps);
        System.out.println("Problema 1 - Assentos reservados: " + Arrays.toString(reservedSeats));

        // Problema 2: Filtro de comentários
        String[] comments = {"The_video_is_good", "I_hate_this", "Informative", "So_hate_ful"};
        int count = solution2(comments.length, "hate", comments);
        System.out.println("Problema 2 - Comentários com 'hate': " + count);

        // Problema 3: Melhor subsequência
        int[] a = {9, 5, 1, 4, 9};
        long minSpecialValue = solution3(a.length, a, 2);
        System.out.println("Problema 3 - Menor valor especial: " + minSpecialValue);
    }

    // ---------- PROBLEMA 1 ----------
    // EN: Reserve the smallest available seat or cancel a reservation
    // PT: Reserve o menor assento disponível ou cancele uma reserva
    static int[] solution1(int N, int K, int[] seat) {
        PriorityQueue<Integer> available = new PriorityQueue<>(); // Min-heap para controlar os assentos livres (garante acesso eficiente ao menor assento disponível)
        Set<Integer> reserved = new HashSet<>(); // Conjunto para rastrear os assentos reservados (HashSet garante buscas rápidas O(1) para verificar se um assento está reservado)
        List<Integer> result = new ArrayList<>(); // Lista com os assentos reservados em ordem

        for (int i = 1; i <= N; i++) available.offer(i); // Preenche a heap com todos os assentos

        for (int i = 0; i < K; i++) {
            int op = seat[i];
            if (op == 0) { // Reservar
                int s = available.poll();
                reserved.add(s);
                result.add(s);
            } else { // Cancelar
                if (reserved.contains(op)) {
                    reserved.remove(op);
                    available.offer(op);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // ---------- PROBLEMA 2 ----------
    // EN: Count how many comments contain a given keyword (case insensitive, split by '_')
    // PT: Contar quantos comentários contêm a palavra-chave (sem diferenciar maiúsculas, separados por '_')
    static int solution2(int N, String S, String[] comments) {
        int result = 0;
        String keyword = S.toLowerCase();

        for (String comment : comments) {
            String[] words = comment.toLowerCase().split("_"); // Normaliza para minúsculas e divide por underline
            for (String word : words) {
                if (word.equals(keyword)) {
                    result++;
                    break; // Evita contar duas vezes o mesmo comentário
                }
            }
        }

        return result;
    }

    // ---------- PROBLEMA 3 ----------
    // EN: Find minimum "special value" of any subsequence of length k
    // PT: Achar o menor "valor especial" entre todas as subsequências de tamanho k
    static long solution3(int n, int[] a, int k) {
        if (k == 1) return 0; // Subsequência de tamanho 1 tem valor 0

        long[][] dp = new long[k][n];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        Arrays.fill(dp[0], 0); // Inicializa a linha base da DP para subsequências de tamanho 1, cujo valor especial é sempre 0

        for (int len = 1; len < k; len++) {
            for (int i = len; i < n; i++) {
                for (int j = len - 1; j < i; j++) {
                    if (dp[len - 1][j] != Long.MAX_VALUE) {
                        long diff = Math.abs((long) a[i] - a[j]); // Calcula diferença absoluta entre os elementos consecutivos
                        dp[len][i] = Math.min(dp[len][i], dp[len - 1][j] + diff);
                    }
                }
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = k - 1; i < n; i++) {
            res = Math.min(res, dp[k - 1][i]);
        }

        return res == Long.MAX_VALUE ? 0 : res; // Caso nenhuma subsequência válida seja encontrada
    }
}
