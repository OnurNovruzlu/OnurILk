
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

class submitListener implements ActionListener {
    HashMap<String,User> allUsersByName = new HashMap<String,User>();

// store a new user or update
allUsersByName.put(username, user);

// look up a user
allUsersByName.get(user);
    public void actionPerformed(ActionEvent e){
        try {
            String newEmail, newUser, systemMsg;
            char[] newPass;
            char[] confirmNewPass;

            newEmail = emailField.getText();
            newUser = usernameField.getText();
            newPass = passwordField.getPassword();
            confirmNewPass = confirmPassField.getPassword();

            String strPass = new String(newPass);
            String strConfPass = new String(confirmNewPass);
            if(strPass.equals(strConfPass) && !newEmail.isEmpty() && !newUser.isEmpty() && 
                    !strPass.isEmpty()){
                BufferedWriter out = new BufferedWriter(new FileWriter("Data.txt", true));
                BufferedWriter emailOut = new BufferedWriter(new FileWriter("email.txt", true));
                out.write(newUser);
                out.write("\t\t");
                out.write(newPass);
                out.write(System.getProperty("line.separator"));
                emailOut.write(newEmail);
                emailOut.write(System.getProperty("line.separator"));
                systemMsg = "New account created, please log in.";
                JOptionPane.showMessageDialog(null, systemMsg);
                ((CardLayout)cardPanel.getLayout()).show(cardPanel, "login");
                emailField.setText(null);
                usernameField.setText(null);
                passwordField.setText(null);
                confirmPassField.setText(null);
                out.close();
                emailOut.close();
            }
            else{
                systemMsg = "Please enter the missing information.";
                JOptionPane.showMessageDialog(null, systemMsg);
            }
        }catch(IOException E){}
    }
}