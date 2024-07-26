import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ChatApp {
    public static void main(String[] args) throws IOException {
        File teamMemberFile = new File("teamMemberFile.txt");
        if (teamMemberFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader("teamMemberFile.txt"));
            String line = reader.readLine();
            Member[] allmembers = new Member[(int) teamMemberFile.length()];
            int i = 0;
            while (line != null) {
                allmembers[i] = new Member();
                allmembers[i].setData(line);
                line = reader.readLine();
                i++;
            }
            allmembers[11].createWindow();
            reader.close();
        }
        else {
            System.out.println("Error: teamMemberFile does not exist.");
        }
    }
    
    public static class Window {
        public void createWindow() {
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
    
            frame.add(panel);
            frame.setSize(1080,720);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("ActionChat");
            frame.setVisible(true);
        }
    }
    public static class Member {
        public String memberName;
        public void setData(String name) {
            memberName = name;
        }
    }
}