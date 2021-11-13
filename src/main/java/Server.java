import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {

        ServerSocket servSocket = new ServerSocket(23444);
        while (true) {

            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new
                         InputStreamReader(socket.getInputStream()))) {
                String x;
                while ((x = in.readLine()) != null) {

                    int f = Integer.parseInt(x);
                    out.println(x + "-е число Фибоначчи равно " + fib(f));

                    if (x.equals("end")) {
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public static int fib(int n) {
        if (n <= 2) return 1;
        int x = 1;
        int y = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = x + y;
            x = y;
            y = res;
        }
        return res;
    }
}