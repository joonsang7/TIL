package sorting;

import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

// 정렬 알고리즘 수행 시간 비교 프로그램
public class Main {
    // 각 알고리즘별 바 색상 정의
    private static final Color[] BAR_COLORS = {
            new Color(0x4E79A7),
            new Color(0xF28E2B),
            new Color(0xE15759),
            new Color(0x76B7B2),
            new Color(0x59A14F),
            new Color(0xEDC948)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 총합 받을 변수
        long selectionSortTimeSum = 0;
        long bubbleSortTimeSum = 0;
        long insertionSortTimeSum = 0;
        long mergeSortTimeSum = 0;
        long quickSortTimeSum = 0;
        long heapSortTimeSum = 0;

        // 사용자로부터 입력 개수 받기
        System.out.print("입력 개수 : ");
        int arraySize = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            long startTime;
            long endTime;

            int[] randomArray = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                randomArray[j] = j + 1;
            }

            Random rand = new Random();
            for (int j = arraySize - 1; j > 0; j--) {
                int idx = rand.nextInt(j + 1);
                int tmp = randomArray[j];
                randomArray[j] = randomArray[idx];
                randomArray[idx] = tmp;
            }

            // 각 알고리즘별로 정렬 수행 시간 측정
            SelectionSort selectionSort = new SelectionSort(randomArray.clone());
            startTime = System.currentTimeMillis();
            selectionSort.SelectionSorting();
            endTime = System.currentTimeMillis();
            selectionSortTimeSum += endTime - startTime;

            BubbleSort bubbleSort = new BubbleSort(randomArray.clone());
            startTime = System.currentTimeMillis();
            bubbleSort.BubbleSorting();
            endTime = System.currentTimeMillis();
            bubbleSortTimeSum += endTime - startTime;

            InsertionSort insertionSort = new InsertionSort(randomArray.clone());
            startTime = System.currentTimeMillis();
            insertionSort.InsertionSorting();
            endTime = System.currentTimeMillis();
            insertionSortTimeSum += endTime - startTime;

            MergeSort mergeSort = new MergeSort(randomArray.clone());
            startTime = System.currentTimeMillis();
            mergeSort.mergeSorting(randomArray.clone(), 0, randomArray.length - 1);
            endTime = System.currentTimeMillis();
            mergeSortTimeSum += endTime - startTime;

            QuickSort quickSort = new QuickSort();
            startTime = System.currentTimeMillis();
            quickSort.quickSort(randomArray.clone());
            endTime = System.currentTimeMillis();
            quickSortTimeSum += endTime - startTime;

            HeapSort heapSort = new HeapSort();
            startTime = System.currentTimeMillis();
            heapSort.heapSorting(randomArray.clone());
            endTime = System.currentTimeMillis();
            heapSortTimeSum += endTime - startTime;
        }

        // 각 알고리즘별 평균 수행 시간 계산
        double[] averageTimes = {
                selectionSortTimeSum / 10.0,
                bubbleSortTimeSum / 10.0,
                insertionSortTimeSum / 10.0,
                mergeSortTimeSum / 10.0,
                quickSortTimeSum / 10.0,
                heapSortTimeSum / 10.0
        };

        // 알고리즘 이름 배열. 각 알고리즘의 이름을 문자열 배열로 저장하여 나중에 차트와 출력에서 사용
        String[] algorithmNames = {
                "선택 정렬",
                "버블 정렬",
                "삽입 정렬",
                "병합 정렬",
                "퀵 정렬",
                "힙 정렬"
        };

        // 알고리즘 수행 시간 출력. 각 알고리즘의 이름과 평균 수행 시간을 포맷팅하여 콘솔에 출력
        System.out.println("알고리즘 수행시간");
        for (int i = 0; i < algorithmNames.length; i++) {
            System.out.printf("%s : %.3f ms\n", algorithmNames[i], averageTimes[i]);
        }

        scanner.close();

        SwingUtilities.invokeLater(() -> createChartFrame(algorithmNames, averageTimes, arraySize));
    }

    // 차트 프레임 생성 메서드. 입력된 알고리즘 이름과 평균 수행 시간 데이터를 바탕으로 차트를 그리는 프레임을 생성
    private static void createChartFrame(String[] labels, double[] values, int arraySize) {
        JFrame frame = new JFrame("정렬 알고리즘 수행 시간 비교");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("입력 개수 " + arraySize + "회 평균 수행 시간(ms)", SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(titleLabel, BorderLayout.NORTH);

        BarChartPanel chartPanel = new BarChartPanel(labels, values);
        frame.add(chartPanel, BorderLayout.CENTER);

        JTextArea legendArea = new JTextArea();
        legendArea.setEditable(false);
        legendArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        legendArea.setText("파란색: 정렬 알고리즘 평균 수행시간\n" +
                "단위: 밀리초(ms), 10회 측정 평균값\n");
        legendArea.setBackground(frame.getBackground());
        legendArea.setBorder(BorderFactory.createEmptyBorder(8, 12, 12, 12));
        frame.add(legendArea, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // 바 차트 패널 클래스. 알고리즘 이름과 평균 수행 시간 데이터를 받아서 차트를 그리는 JPanel을 정의한다.
    private static class BarChartPanel extends JPanel {
        private final String[] labels;
        private final double[] values;

        BarChartPanel(String[] labels, double[] values) {
            this.labels = labels;
            this.values = values;
            setPreferredSize(new Dimension(920, 520));
        }

        // 차트 그리기 메서드. 그래픽 컨텍스트를 사용하여 차트를 그리는 로직을 구현한다. 축, 눈금, 바, 레이블 등을 그린다.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int margin = 60;
            int labelMargin = 40;
            int chartWidth = width - 2 * margin;
            int chartHeight = height - 2 * margin - labelMargin;

            double maxValue = 0;
            for (double value : values) {
                maxValue = Math.max(maxValue, value);
            }
            maxValue = Math.max(maxValue, 1.0);

            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, width, height);
            g2.setColor(Color.GRAY);
            g2.drawLine(margin, margin, margin, margin + chartHeight);
            g2.drawLine(margin, margin + chartHeight, margin + chartWidth, margin + chartHeight);

            int numberYDivisions = 6;
            for (int i = 0; i <= numberYDivisions; i++) {
                int y = margin + chartHeight - (i * chartHeight / numberYDivisions);
                g2.setColor(new Color(220, 220, 220));
                g2.drawLine(margin, y, margin + chartWidth, y);
                g2.setColor(Color.DARK_GRAY);
                String yLabel = String.format("%.1f", maxValue * i / numberYDivisions);
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, margin - labelWidth - 8, y + (metrics.getHeight() / 2) - 3);
            }

            int barCount = values.length;
            int barSpacing = 20;
            int availableWidth = chartWidth - (barSpacing * (barCount + 1));
            int barWidth = Math.max(40, availableWidth / barCount);
            int x = margin + barSpacing;

            for (int i = 0; i < barCount; i++) {
                int barHeight = (int) ((values[i] / maxValue) * (chartHeight - 20));
                int y = margin + chartHeight - barHeight;
                g2.setColor(BAR_COLORS[i % BAR_COLORS.length]);
                g2.fillRect(x, y, barWidth, barHeight);
                g2.setColor(Color.DARK_GRAY);
                g2.drawRect(x, y, barWidth, barHeight);

                String valueLabel = String.format("%.2f", values[i]);
                FontMetrics metrics = g2.getFontMetrics();
                int valueLabelWidth = metrics.stringWidth(valueLabel);
                g2.drawString(valueLabel, x + (barWidth - valueLabelWidth) / 2, y - 8);

                String label = labels[i];
                int labelWidth = metrics.stringWidth(label);
                g2.drawString(label, x + (barWidth - labelWidth) / 2, margin + chartHeight + metrics.getHeight() + 4);

                x += barWidth + barSpacing;
            }

            g2.dispose();
        }
    }
}
