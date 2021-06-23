import java.util.*;
class Machine {
        static String lastMachine = "";
        boolean isUp;
        boolean lastReceived;
    
        public Machine() {
            isUp = true;
            lastReceived = false;
        }
    
        public boolean isLastReceived() {
            return lastReceived;
        }
    
        public void setLastReceived(boolean lastReceived) {
            this.lastReceived = lastReceived;
        }
    
        List<String> queries = new ArrayList<>();
    
        public List<String> getQueries() {
            return queries;
        }
    
        public void setQueries(List<String> queries) {
            this.queries = queries;
        }
    
        public boolean isUp() {
            return isUp;
        }
    
        public void setUp(boolean up) {
            isUp = up;
        }

		@Override
		public String toString() {
			return "Machine [isUp=" + isUp + ", lastReceived=" + lastReceived + ", queries=" + queries + "]";
		}
        
    }
    
    class ReverseProxy {
        Map<String, Machine> machineHashMap = new TreeMap<>();
    
        public Map<String, Machine> getMachineHashMap() {
            return machineHashMap;
        }
    
        public void setMachineHashMap(Map<String, Machine> machineHashMap) {
            this.machineHashMap = machineHashMap;
        }

		@Override
		public String toString() {
			return "ReverseProxy [machineHashMap=" + machineHashMap + "]";
		}
        
    }
    
    class TestClass {
        public static void main(String args[]) throws Exception {
    
            Map<String, ReverseProxy> reverseProxyMap = new HashMap<>();
            Scanner s = new Scanner(System.in);
            int n = Integer.parseInt(s.nextLine());
            String machines = s.nextLine();
            int r = Integer.parseInt(s.nextLine());
            for (int i = 0; i < r; i++) {
                String proxyName = s.nextLine();
                int m = Integer.parseInt(s.nextLine());
                String machinesR = s.nextLine();
                ReverseProxy reverseProxy = new ReverseProxy();
                String[] myMachines = machinesR.split(" ");
                for (String myMachine : myMachines) {
                    reverseProxy.getMachineHashMap().put(myMachine, new Machine());
                }
                reverseProxyMap.put(proxyName, reverseProxy);
            }
    //        System.out.println("machine: " + reverseProxyMap);
    
            int q = Integer.parseInt(s.nextLine());
            for (int i = 0; i < q; i++) {
                String query = s.nextLine();
                executeQuery(reverseProxyMap, query);
            }
    
            Set<String> keySet = reverseProxyMap.keySet();
            for (String key : keySet) {
                ReverseProxy reverseProxy = reverseProxyMap.get(key);
                Map<String, Machine> hashMap = reverseProxy.getMachineHashMap();
                Set<String> keySet1 = hashMap.keySet();
                for (String k : keySet1) {
    
                }
            }
    
    
        }
    
        private static void executeQuery(Map<String, ReverseProxy> reverseProxyMap, String query) {
            String[] strings = query.split("/", 2);
            String proxyName = strings[0];
            String remainingQuery = strings[1];
            Map<String, Machine> machineHashMap = reverseProxyMap.get(proxyName).getMachineHashMap();
            if (remainingQuery.contains("machine_down")) {
                String[] split = remainingQuery.split("=");
                String machineName = split[1];
                machineHashMap.get(machineName).setUp(false);
            } else if (remainingQuery.contains("machine_up")) {
                String[] split = remainingQuery.split("=");
                String machineName = split[1];
                machineHashMap.get(machineName).setUp(true);
            } else {
                Set<String> keySet = machineHashMap.keySet();
                for (String key : keySet) {
                    Machine machine = machineHashMap.get(key);
                    if (!Machine.lastMachine.equals(key)) {
                        if (machine.isUp) {
                            machine.getQueries().add(query);
                            Machine.lastMachine = key;
                        }
                    } else {
                    	
                        if (machine.isUp) {
                            machine.getQueries().add(query);
                            Machine.lastMachine = key;
                        }
                    }
                }
            }
    
        }
    
    
    }