import java.util.*;

class Stat{
  
  public static int count(double[] arr) {
    return arr.length;
  }

  public static double sum(double[] arr) {
    double sum = 0;
    for(double a : arr){
      sum += a;
    }
    return sum;
  }

  public static double min(double[] arr) {
    double min = arr[0];
    for (double a : arr) {
      if (a < min) {
        min = a;
      }
    }
    return min;
  }

  public static double max(double[] arr) {
    double max = arr[0];
    for (double a : arr) {
      if (a > max) {
        max = a;
      }
    }
    return max;
  }

  public static double range(double[] arr) {
    return max(arr) - min(arr);
  }

  public static double mean(double[] arr) {
    return (double) sum(arr) / count(arr);
  }

  public static double median(double[] arr) {
    Arrays.sort(arr);
    int n = count(arr);
    return (n % 2 != 0) ? (arr[n / 2 - 1] + arr[n / 2]) / 2.0 : arr[n / 2];
  }

  public static double var(double[] arr) {
    double sum = sum(arr);
    double mean = mean(arr);
    double sumSquaredDifferences = 0;
    for (double num : arr) {
      double diff = (double) num - mean;
      sumSquaredDifferences += Math.pow(diff, 2);
    }
    return (double) sumSquaredDifferences / count(arr);
  }

  public static double std(double[] arr) {
    return Math.sqrt(var(arr));
  }

  public static Map<Double, Integer> mode(double[] arr) {
    Arrays.sort(arr);
    Map<Double, Integer> frequencyMap = new HashMap<>();
  
    double currentElement = arr[0];
    int currentFrequency = 1;
  
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == currentElement) {
        currentFrequency++;
      } else {
        frequencyMap.put(currentElement, currentFrequency);
        currentElement = arr[i];
        currentFrequency = 1;
      }
    }
  
    frequencyMap.put(currentElement, currentFrequency);
  
    int maxFrequency = 0;
    for (int frequency : frequencyMap.values()) {
      if (frequency > maxFrequency) {
        maxFrequency = frequency;
      }
    }
  
    List<Double> modes = new ArrayList<>();
    for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
      if (entry.getValue() == maxFrequency) {
        modes.add(entry.getKey());
      }
    }
  
    Map<Double, Integer> modeMap = new HashMap<>();
    for (double mode : modes) {
      modeMap.put(mode, maxFrequency);
    }
  
    return modeMap;
  }
}
