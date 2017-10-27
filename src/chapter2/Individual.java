package chapter2;

/**  个体拥有染色体 个体的适应性 offset应该就是偏移量  **/





public class Individual {                   //独立个体类
    private int[] chromosome;   //染色体
    private double fitness = -1;//个体适应性初始设置为-1
    public Individual(int[] chromosome){    //以染色体初始化一个个体
        this.chromosome = chromosome;
    }   //以一条染色体初始化一个个体

    public Individual(int chromosomeLength){        //以染色体长度初始化一个个体
        this.chromosome = new int[chromosomeLength];
        for (int gene = 0; gene < chromosomeLength; ++gene) {
            if(0.5 < Math.random()){                //随机生成染色体
                this.setGene(gene,1);
            }else {
                this.setGene(gene,0);
            }
        }
    }

    public int[] getChromosome(){
        return this.chromosome;
    }

    public int getChromosomeLength(){
        return this.chromosome.length;
    }

    public int getGene(int offset){
        return this.chromosome[offset];
    }

    public void setGene(int offset,int gene){
        this.chromosome[offset] = gene;
    }

    public void setFitness(double fitness){
        this.fitness = fitness;
    }

    public double getFitness(){
        return this.fitness;
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < this.chromosome.length; ++i) {  //
            output += this.chromosome[i];
        }
        return output;
    }
}
