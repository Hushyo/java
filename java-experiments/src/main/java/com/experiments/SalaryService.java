package com.experiments;

public class SalaryService {
    public static double getTotalSalaries(Workable[] employees){
        double total = 0;
        for(Workable employee : employees){
            total += employee.calculateSalary();
        }
        return total;
    }
}
