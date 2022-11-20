
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

private class LoginListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String username, inUsername, inPass, str = "Incorrect username or password.";
        char[] password;

        username = usernameField.getText();
        password = passwordField.getPassword();
        //Convert char to str
        String convertPass = new String(password);

        try {
            fileScan = new Scanner(new File("Data.txt"));
        }catch(Exception err){}

        while(fileScan.hasNext()){
            inUsername = fileScan.next();
            inPass = fileScan.next();
            if(username.equals(inUsername) && convertPass.equals(inPass)){
                ((CardLayout)cardPanel.getLayout()).show(cardPanel, "main");
                counter++;
            }
        }
        if(counter == 0){
            JOptionPane.showMessageDialog(null, str);   
            usernameField.setText(null);
            passwordField.setText(null);
        }
        fileScan.close();
    }
}