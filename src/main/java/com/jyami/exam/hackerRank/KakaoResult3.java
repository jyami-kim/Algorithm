package com.jyami.exam.hackerRank;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/06/29
 */
public class KakaoResult3 {

    public static List<Integer> solution(int k, List<Integer> arrival, List<Integer> load) {

        ServerCounter serverCounter = new ServerCounter(k);

        PriorityQueue<Work> workerQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.arrival));

        for (int i = 0; i < arrival.size(); i++) {
            workerQueue.offer(new Work(arrival.get(i), load.get(i)));
        }

        while (!workerQueue.isEmpty()) {
            Work work = workerQueue.poll();
            Server availableServer = serverCounter.findAvailableServer(work);
            if (availableServer != null) {
                availableServer.inputWork(work);
            }
        }

        return serverCounter.getWorkTimeMaxServers();
    }

    public static class Work {
        private int arrival;
        private int load;
        private int finish;

        public Work(int arrival, int load) {
            this.arrival = arrival;
            this.load = load;
            this.finish = arrival + load - 1;
        }
    }

    public static class Server {
        private int index;
        private int workTime;
        private int processFinish = 0;

        public Server(int index, int workTime) {
            this.index = index;
            this.workTime = workTime;
        }

        public void inputWork(Work work) {
            workTime += work.load;
            processFinish = work.finish;
        }

        public boolean canProcess(Work work) {
            return processFinish < work.arrival;
        }
    }

    public static class ServerCounter {
        private int roundRobin = 0;
        private int numberOfServer;
        List<Server> servers = new ArrayList<>();

        public ServerCounter(int numberOfServer) {
            this.numberOfServer = numberOfServer;
            for (int i = 0; i < numberOfServer; i++) {
                Server server = new Server(i + 1, 0);
                servers.add(server);
            }
        }

        public Server findAvailableServer(Work work) { // roundRobin
            for (int i = 0; i < numberOfServer; i++) {
                if (servers.get(roundRobin).canProcess(work)) {
                    Server find = servers.get(roundRobin);
                    roundRobin = (roundRobin + 1) % numberOfServer;
                    return find;
                }
                roundRobin = (roundRobin + 1) % numberOfServer;
            }
            return null;
        }

        public List<Integer> getWorkTimeMaxServers(){
            int max = getMaxTime();
            return servers.stream()
                    .filter(server -> server.workTime == max)
                    .map(server -> server.index)
                    .collect(Collectors.toList());
        }

        private int getMaxTime(){
            return servers.stream()
                    .mapToInt(server -> server.workTime)
                    .max().getAsInt();
        }

    }

    public static void main(String[] args) {
        List<Integer> solution = solution(3, Arrays.asList(1, 2, 12, 5, 6, 30, 32),
                Arrays.asList(15, 10, 10, 10, 10, 15, 10));
        System.out.println(solution);
    }
}
