package chapter2;

/**
 *种群由一定数量的个体组成 有种群适应性
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {
    private Individual population[];                        //嵌套Individual类对象
    private double populationFitness = -1;                  //种群适应性初始设置为-1


    public Population(int populationSize){                  //以种群数量作为变量构造一个种群
        this.population = new Individual[populationSize];
    }
    /**...**/

    public Population(int populationSize,int chromosomeLength){ //以种群大小和染色体长度作为变量构造一个种群
        this.population = new Individual[populationSize];

        for (int indivdualCount = 0; indivdualCount < populationSize; ++indivdualCount) {
            Individual individual = new Individual(chromosomeLength);
            this.population[indivdualCount] = individual;
        }
    }

    public Individual[] getIndividuals(){ //带回种群
        return this.population;
    }


    public Individual getFittest(int offset) {  //得到适应性最强的个体
        Arrays.sort(this.population, new Comparator<Individual>() {     /** #1.sort() 针对 <T> 自定义类型的数组
                                                                            比较数组中的每一项
                                                                            #2.compare() **/
            @Override
            public int compare(Individual o1, Individual o2) {         //重写了比较函数
                if(o1.getFitness() > o2.getFitness()){
                    return -1;
                } else if(o1.getFitness() < o2.getFitness()){
                    return 1;
                }
                return 0;

            }
        });
        return this.population[offset];        //实际上带回的还是最强适应性的那个个体
    }

    public void setPopulationFitness(){
        this.populationFitness = fitness;
    }

    public double getPopulationFitness() {
        return this.populationFitness;
    }

    public int getSize() {
        return this.population.length;
    }

    public Individual setIndividual(int offset,Individual individual) {
        return population[offset] = individual;
    }

    public Individual getIndividual(int offet) {
        return population[offet];
    }

    public void shuffle() {     //洗牌 确实也就是洗洗牌。。。
        Random rnd = new Random();
        for (int i = population.length - 1; i > 0; --i) {
            int index = rnd.nextInt(i + 1);
            Individual a = population[index];
            population[index] = population[i];
            population[i] = a;

        }
    }
}
/**
 protected int next(int bits) {
 long oldseed, nextseed;
 AtomicLong seed = this.seed;
 do {
 oldseed = seed.get();
 nextseed = (oldseed * multiplier + addend) & mask;
 } while (!seed.compareAndSet(oldseed, nextseed));
 return (int)(nextseed >>> (48 - bits));
 }


 public int nextInt() {
 return next(32);
 }

