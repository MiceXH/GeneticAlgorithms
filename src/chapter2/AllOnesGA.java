package chapter2;

/**
 * Created by mice on 2017/7/8.
 */
public class AllOnesGA {
    public static void main(String[] args){
        //创建一个遗传算法的实例
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(100,0.01,0.95,0);

        //实例化一个种群
        Population population = geneticAlgorithm.initPopulation(50);
    }
}
