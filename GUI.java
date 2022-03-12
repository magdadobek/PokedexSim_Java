import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class GUI {

    static JFrame frame1 = new JFrame("Pokedex Simulator");

    static JLabel pokemonPicture = new JLabel(new ImageIcon("src\\pokemon.png"));
    static JLabel background = new JLabel(new ImageIcon("src\\background.png"));
    static JPanel container1 = new JPanel();

    static JFrame frame2 = new JFrame("Pokedex Simulator");
    static JPanel panel = new JPanel(null);
    static JLayeredPane layers = new JLayeredPane();
    static JLabel generationLabel = new JLabel("Generation");
    static JLabel gamevLabel = new JLabel("Game Version");
    static JLabel nameLabel = new JLabel("Name: ");
    static JLabel typeLabel = new JLabel("Type/s:");
    static JLabel statsLabel = new JLabel("Stats:");
    static JLabel hpLabel = new JLabel("HP:");
    static JLabel attackLabel = new JLabel("Attack:");
    static JLabel defenseLabel = new JLabel("Defense:");
    static JLabel speedLabel = new JLabel("Speed:");
    static JLabel descriptionLabel = new JLabel("Description: ");

    static String[] generations = {"Generation 1", "Generation 2", "Generation 3", "Generation 4", "Generation 5"};
    static String[] gen1 ={"Red", "Blue", "Yellow"};
    static String[] gen2 ={"Gold", "Silver", "Crystal"};
    static String[] gen3 ={"Ruby", "Sapphire", "Emerald"};
    static String[] gen4 ={"Diamond", "Pearl", "Platinum"};
    static String[] gen5 ={"Black", "White", "Black 2", "White 2"};

    static JComboBox generationCB = new JComboBox(generations);
    static JComboBox GVCB;
    static JLabel pokePic;
    static JCheckBox[] checkboxes = new JCheckBox[18];
    static JLabel[] typePics = new JLabel[18];

    static JFrame frame3 = new JFrame("Pokedex Simulator");
    static JLabel pokedexPic = new JLabel(new ImageIcon("src\\Pokedex.png"));
    static JList<String> list = new JList();
    static JLabel region = new JLabel("Region:");

    static JTabbedPane tabs = new JTabbedPane();
    static JLabel[] weakness = new JLabel[18];
    static JLabel tName, tHP, tAttack, tSpeed, tDefense, tGeneration, tGV, tPicture, tType1, tType2,tRegion;
    static JTextArea tDescription;

    public static void createFrame1(){
        frame2.setVisible(false);
        frame3.setVisible(false);

        frame1=new JFrame("Pokedex Simulator");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(890,430);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);

        pokemonPicture.setSize(840,215);
        pokemonPicture.setLocation(15,15);
        frame1.add(pokemonPicture);

        container1.setLayout(new FlowLayout());
        container1.setSize(840,120);
        container1.setLocation(15,240);
        container1.setOpaque(false);
        frame1.add(container1);

        background.setSize(889,429);
        background.setLocation(1,1);
        frame1.add(background);

        JButton addNewButton = new JButton("Add new");
        addNewButton.setPreferredSize(new Dimension(410,115));
        container1.add(addNewButton);

        JButton viewListButton = new JButton(("View List"));
        viewListButton.setPreferredSize(new Dimension(410,115));
        container1.add(viewListButton);

        container1.revalidate();
        container1.repaint();
        frame1.revalidate();
        frame1.repaint();

        addNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFrame2();
            }
        });

        viewListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {createFrame3();}
        });

    }

    public  static void createFrame2(){
        frame1.setVisible(false);

        frame2=new JFrame("Pokedex Simulator");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(955,595);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

        layers = new JLayeredPane();
        layers.setSize(954,594);
        layers.setLocation(1,1);
        frame2.add(layers);

        background.setSize(954,594);
        background.setLocation(1,1);
        layers.add(background, 1,0);

        panel = new JPanel(null);
        panel.setSize(954,594);
        panel.setLocation(1,1);
        panel.setOpaque(false);
        layers.add(panel,2,0);

        generationLabel.setLocation(55,35);
        generationLabel.setSize(80,15);
        panel.add(generationLabel);

        gamevLabel.setLocation(220,35);
        gamevLabel.setSize(100,15);
        panel.add(gamevLabel);

        nameLabel.setLocation(355,60);
        nameLabel.setSize(50,15);
        panel.add(nameLabel);

        typeLabel.setLocation(55,115);
        typeLabel.setSize(55,15);
        panel.add(typeLabel);

        statsLabel.setLocation(410,310);
        statsLabel.setSize(45,15);
        panel.add(statsLabel);

        hpLabel.setLocation(410,340);
        hpLabel.setSize(30,15);
        panel.add(hpLabel);

        attackLabel.setLocation(410,370);
        attackLabel.setSize(50,15);
        panel.add(attackLabel);

        defenseLabel.setLocation(410,400);
        defenseLabel.setSize(65,15);
        panel.add(defenseLabel);

        speedLabel.setLocation(410,430);
        speedLabel.setSize(55,15);
        panel.add(speedLabel);

        JTextField hpTF = new JTextField();
        hpTF.setLocation(500,340);
        hpTF.setSize(80,20);
        panel.add(hpTF);

        JTextField attackTF = new JTextField();
        attackTF.setLocation(500,370);
        attackTF.setSize(80,20);
        panel.add(attackTF);

        JTextField defenseTF = new JTextField();
        defenseTF.setLocation(500,400);
        defenseTF.setSize(80,20);
        panel.add(defenseTF);

        JTextField speedTF = new JTextField();
        speedTF.setLocation(500,430);
        speedTF.setSize(80,20);
        panel.add(speedTF);

        generationCB.setLocation(15,55);
        generationCB.setSize(160,25);
        panel.add(generationCB);

        JTextField nameText = new JTextField();
        nameText.setLocation(415,55);
        nameText.setSize(415,25);
        panel.add(nameText);

        descriptionLabel.setLocation(615,310);
        descriptionLabel.setSize(85,15);
        panel.add(descriptionLabel);

        JTextArea descriptionTA = new JTextArea();
        descriptionTA.setLocation(615,335);
        descriptionTA.setSize(300,140);
        descriptionTA.setLineWrap(true);
        panel.add(descriptionTA);

        JTextField fileText = new JTextField();
        fileText.setLocation(415,85);
        fileText.setSize(415,25);
        panel.add(fileText);

        JButton backButton=new JButton("Back");
        backButton.setLocation(850,10);
        backButton.setSize(75,25);
        panel.add(backButton);

        JButton addButton=new JButton("Add");
        addButton.setLocation(755,480);
        addButton.setSize(155,55);
        panel.add(addButton);

        JButton fileButton=new JButton("Open...");
        fileButton.setLocation(315,85);
        fileButton.setSize(90,25);
        panel.add(fileButton);

        for(int i=0;i<18;i++){
            String path ="src\\"+ i +".png";
            typePics[i]=new JLabel(new ImageIcon(path));
            typePics[i].setSize(50,50);
            Pokemon.add_types();
            checkboxes[i]=new JCheckBox(Pokemon.types.get(i));
            checkboxes[i].setSize(80,20);
            checkboxes[i].setOpaque(false);
            if(i>11){
                typePics[i].setLocation(270,140+(55*(i-12)));
                checkboxes[i].setLocation(320,150+(55*(i-12)));
            }
            else if(i>5){
                typePics[i].setLocation(140,140+(55*(i-6)));
                checkboxes[i].setLocation(190,150+(55*(i-6)));
            }
            else{
                typePics[i].setLocation(10,140+(55*i));
                checkboxes[i].setLocation(60,150+(55*i));
            }

            checkboxes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selected =0;
                    for(int i=0;i<18;i++){
                        if(checkboxes[i].isSelected()){
                            selected++;
                        }
                    }
                    if(selected==2){
                        for(int j=0;j<18;j++){
                            checkboxes[j].setEnabled(false);
                            if(checkboxes[j].isSelected()){
                                checkboxes[j].setEnabled(true);
                            }
                        }
                    }
                    else{
                        for (int k=0;k<18;k++){
                            checkboxes[k].setEnabled(true);
                        }
                    }
                }
            });

            panel.add(typePics[i]);
            panel.add(checkboxes[i]);
        }

        frame2.revalidate();
        frame2.repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFrame1();
            }
        });

        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileDialog = new JFileChooser();
                fileDialog.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result =fileDialog.showOpenDialog(frame1);
                if(result ==JFileChooser.APPROVE_OPTION){
                    if(!(pokePic==null)) panel.remove(pokePic);
                    File selected = fileDialog.getSelectedFile();
                    fileText.setText(selected.getPath());
                    pokePic=new JLabel(new ImageIcon(selected.getPath()));
                    pokePic.setLocation(415,115);
                    pokePic.setSize(415,175);
                    panel.add(pokePic);

                    frame2.revalidate();
                    frame2.repaint();
                }
            }
        });

        generationCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(GVCB==null)) panel.remove(GVCB);
                int index =generationCB.getSelectedIndex();
                if(index==0){
                    GVCB=new JComboBox(gen1);
                    GVCB.setLocation(185,55);
                    GVCB.setSize(160,25);
                }
                else if(index==1){
                    GVCB=new JComboBox(gen2);
                    GVCB.setLocation(185,55);
                    GVCB.setSize(160,25);
                }
                else if(index==2){
                    GVCB=new JComboBox(gen3);
                    GVCB.setLocation(185,55);
                    GVCB.setSize(160,25);
                }
                else if(index==3){
                    GVCB=new JComboBox(gen4);
                    GVCB.setLocation(185,55);
                    GVCB.setSize(160,25);
                }
                else if(index==4){
                    GVCB=new JComboBox(gen5);
                    GVCB.setLocation(185,55);
                    GVCB.setSize(160,25);
                }
                panel.add(GVCB);

                frame2.revalidate();
                frame2.repaint();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean alright=false;
                try{
                    Integer control = Integer.parseInt(hpTF.getText());
                    control=Integer.parseInt(attackTF.getText());
                    control=Integer.parseInt(defenseTF.getText());
                    control=Integer.parseInt(speedTF.getText());
                    alright=true;
                }catch (NumberFormatException a){}
                if(nameText.getText().isEmpty()||hpTF.getText().isEmpty()||attackTF.getText().isEmpty()||defenseTF.getText().isEmpty()||speedTF.getText().isEmpty()||descriptionTA.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame2,"All textfields must be filled!");
                }
                else if(alright==false) JOptionPane.showMessageDialog(frame2, "Stats must be numbers!");
                else{
                    Pokemon.add_types();
                    Pokemon.add_types_weaknesses();
                    int type1=18, type2=18;
                    for(int i=0;i<18;i++){
                        if(checkboxes[i].isSelected()){
                            type1=i;
                            break;
                        }
                    }
                    if (type1==18){
                        JOptionPane.showMessageDialog(frame2,"Pick a type!");
                        return;
                    }
                    else {
                        for(int i=0;i<18;i++){
                            if(checkboxes[i].isSelected()&&type1!=i){
                                type2=i;
                                break;
                            }
                        }
                    }
                    int size = Pokemon.pokedex.size();
                    int index1=generationCB.getSelectedIndex();
                    if(index1==0){
                        int index2 = GVCB.getSelectedIndex();
                        if (index2==0){
                            if(type2==18){
                                new Red(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Red(nameText.getText(),
                                    Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                    type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                        }
                        }
                        else if (index2==1){
                            if(type2==18){
                                new Blue(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                           }
                            else{
                                new Blue(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==2){
                            if(type2==18){
                                new Yellow(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Yellow(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else JOptionPane.showMessageDialog(frame2,"Game version not chosen");
                    }
                    else if(index1==1){
                        int index2 = GVCB.getSelectedIndex();
                        if (index2==0){
                            if(type2==18){
                                new Gold(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Gold(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==1){
                            if(type2==18){
                                new Silver(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Silver(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==2){
                            if(type2==18){
                                new Crystal(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Crystal(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else JOptionPane.showMessageDialog(frame2,"Game version not chosen");
                    }
                    else if(index1==2){
                        int index2 = GVCB.getSelectedIndex();
                        if (index2==0){
                            if(type2==18){
                                new Ruby(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Ruby(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==1){
                            if(type2==18){
                                new Sapphire(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Sapphire(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==2){
                            if(type2==18){
                                new Emerald(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Emerald(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else JOptionPane.showMessageDialog(frame2,"Game version not chosen");
                    }
                    else if(index1==3){
                        int index2 = GVCB.getSelectedIndex();
                        if (index2==0){
                            if(type2==18){
                                new Diamond(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Diamond(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==1){
                            if(type2==18){
                                new Pearl(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Pearl(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==2){
                            if(type2==18){
                                new Platinum(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Platinum(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else JOptionPane.showMessageDialog(frame2,"Game version not chosen");
                    }
                    else if(index1==4){
                        int index2 = GVCB.getSelectedIndex();
                        if (index2==0){
                            if(type2==18){
                                new Black(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Black(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==1){
                            if(type2==18){
                                new White(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new White(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==2){
                            if(type2==18){
                                new Black2(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new Black2(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else if (index2==3){
                            if(type2==18){
                                new White2(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                            else{
                                new White2(nameText.getText(),
                                        Integer.parseInt(hpTF.getText()),Integer.parseInt(attackTF.getText()),Integer.parseInt(defenseTF.getText()),Integer.parseInt(speedTF.getText()),
                                        type1,type2, descriptionTA.getText(),fileText.getText());
                                if(size<Pokemon.pokedex.size()) JOptionPane.showMessageDialog(frame2, "Pokemon added successfully");
                                frame2.dispose();
                                createFrame2();
                                System.out.println(Pokemon.pokedex);
                            }
                        }
                        else JOptionPane.showMessageDialog(frame2,"Game version not chosen");
                    }
                }
            }
        });
    }

    public static void createFrame3(){
        frame1.setVisible(false);

        frame3=new JFrame("Pokedex Simulator");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(1100,600);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);

        layers = new JLayeredPane();
        layers.setSize(1394,599);
        layers.setLocation(1,1);
        frame3.add(layers);

        panel = new JPanel(null);
        panel.setSize(1394,599);
        panel.setLocation(1,1);
        panel.setOpaque(false);
        layers.add(panel,2,0);

        background.setLocation(1,1);
        background.setSize(1394,599);
        layers.add(background,1,0);

        tabs=new JTabbedPane();
        tabs.setLocation(15,85);
        tabs.setSize(740,455);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);
        tabs.addTab("Info",panel1);
        tabs.addTab("Weaknesses",panel2);
        panel.add(tabs);

        nameLabel.setLocation(375,5);
        nameLabel.setSize(50,15);
        panel1.add(nameLabel);

        statsLabel.setLocation(375,55);
        statsLabel.setSize(45,15);
        panel1.add(statsLabel);

        hpLabel.setLocation(375,85);
        hpLabel.setSize(30,15);
        panel1.add(hpLabel);

        attackLabel.setLocation(375,100);
        attackLabel.setSize(50,15);
        panel1.add(attackLabel);

        speedLabel.setLocation(375,115);
        speedLabel.setSize(50,15);
        panel1.add(speedLabel);

        defenseLabel.setLocation(375,135);
        defenseLabel.setSize(65,15);
        panel1.add(defenseLabel);

        generationLabel.setLocation(375,180);
        generationLabel.setSize(85,15);
        panel1.add(generationLabel);

        gamevLabel.setLocation(375,210);
        gamevLabel.setSize(100,15);
        panel1.add(gamevLabel);

        region.setLocation(375,240);
        region.setSize(55,15);
        panel1.add(region);

        descriptionLabel.setLocation(10,250);
        descriptionLabel.setSize(80,15);
        panel1.add(descriptionLabel);

        JButton releaseButton = new JButton("Release");
        releaseButton=new JButton("Release");
        releaseButton.setLocation(610,175);
        releaseButton.setSize(100,30);
        panel1.add(releaseButton);


        JButton changeButton = new JButton("<html><center>"+"Change"+"<br>"+"name"+"</center></html>");
        changeButton.setLocation(610,210);
        changeButton.setSize(100,55);
        changeButton.setHorizontalTextPosition(SwingConstants.LEFT);
        panel1.add(changeButton);

        for(int i=0;i<18;i++){
            String path ="src\\"+ i +".png";
            typePics[i]=new JLabel(new ImageIcon(path));
            typePics[i].setSize(50,50);
            Pokemon.add_types();
            if(i>11){
                typePics[i].setLocation(500,35+(55*(i-12)));
            }
            else if(i>5){
                typePics[i].setLocation(255,35+(55*(i-6)));
            }
            else{
                typePics[i].setLocation(10,35+(55*i));
            }
            panel2.add(typePics[i]);
        }

        pokedexPic.setLocation(15,15);
        pokedexPic.setSize(290,60);
        panel.add(pokedexPic);

        String[] nameList = new String[Pokemon.pokedex.size()];
        for(int i=0;i<nameList.length;i++){
            nameList[i]=Pokemon.pokedex.get(i).name;
        }
        list = new JList(nameList);
        JScrollPane SP = new JScrollPane(list);
        SP.setLocation(775,50);
        SP.setSize(290,450);
        SP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(SP);

        JButton backButton = new JButton("Back");
        backButton.setLocation(980,10);
        backButton.setSize(75,25);
        panel.add(backButton);

        JButton exportButton=new JButton("Export Pokedex");
        exportButton.setLocation(775,510);
        exportButton.setSize(140,25);
        panel.add(exportButton);

        JButton importButton = new JButton("Import Pokedex");
        importButton=new JButton("Import Pokedex");
        importButton.setLocation(930,510);
        importButton.setSize(140,25);
        panel.add(importButton);

        frame3.repaint();
        frame3.revalidate();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFrame1();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            final JLabel[] weakness = new JLabel[18];
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if(!list.isSelectionEmpty()) {
                        String name = list.getSelectedValue();
                        String[] info = Pokemon.pokedex.get(Pokemon.getIndex(name)).toString().split("\n");
                        if (tName == null) tName = new JLabel();
                        tName.setText(name);
                        tName.setSize(55, 15);
                        tName.setLocation(510, 5);
                        panel1.add(tName);
                        if (tHP == null) tHP = new JLabel();
                        tHP.setText(info[1]);
                        tHP.setLocation(510, 85);
                        tHP.setSize(55, 15);
                        panel1.add(tHP);
                        if (tAttack == null) tAttack = new JLabel();
                        tAttack.setText(info[2]);
                        tAttack.setLocation(510, 100);
                        tAttack.setSize(55, 15);
                        panel1.add(tAttack);
                        if (tSpeed == null) tSpeed = new JLabel();
                        tSpeed.setText(info[3]);
                        tSpeed.setLocation(510, 115);
                        tSpeed.setSize(55, 15);
                        panel1.add(tSpeed);
                        if (tDefense == null) tDefense = new JLabel();
                        tDefense.setText(info[4]);
                        tDefense.setLocation(510, 130);
                        tDefense.setSize(55, 15);
                        panel1.add(tDefense);
                        if (tGeneration == null) tGeneration = new JLabel();
                        tGeneration.setText(info[7]);
                        tGeneration.setLocation(510, 180);
                        tGeneration.setSize(55, 15);
                        panel1.add(tGeneration);
                        if (tGV == null) tGV = new JLabel();
                        tGV.setText(info[8]);
                        tGV.setLocation(510, 210);
                        tGV.setSize(55, 15);
                        panel1.add(tGV);
                        if (tType1 == null) tType1 = new JLabel();
                        String[] types = info[5].split("/");
                        tType1.setIcon(new ImageIcon("src\\" + types[0] + ".png"));
                        tType1.setLocation(590, 5);
                        tType1.setSize(50, 50);
                        panel1.add(tType1);
                        if (info[5].contains("/")) {
                            if (tType2 == null) tType2 = new JLabel();
                            tType2.setIcon(new ImageIcon("src\\" + types[1] + ".png"));
                            tType2.setLocation(645, 5);
                            tType2.setSize(50, 50);
                            panel1.add(tType2);
                        } else {
                            if (tType2 != null) panel1.remove(tType2);
                        }
                        if (tPicture == null) tPicture = new JLabel();
                        tPicture.setIcon(new ImageIcon(info[10]));
                        tPicture.setLocation(5, 5);
                        tPicture.setSize(360, 240);
                        panel1.add(tPicture);
                        if (tDescription == null) tDescription = new JTextArea();
                        tDescription.setSize(720, 145);
                        tDescription.setLocation(5, 270);
                        tDescription.setEditable(false);
                        tDescription.setLineWrap(true);
                        tDescription.setText(info[9]);
                        panel1.add(tDescription);
                        if (tRegion == null) tRegion = new JLabel();
                        tRegion.setText(info[6]);
                        tRegion.setSize(55, 15);
                        tRegion.setLocation(510, 240);
                        panel1.add(tRegion);

                        for (int i = 0; i < 18; i++) {
                            Pokemon.add_types_weaknesses();
                            String value = "" + Pokemon.pokedex.get(Pokemon.getIndex(name)).weaknesses[i];
                            if (weakness[i] == null) weakness[i] = new JLabel();
                            weakness[i].setText(value);
                            weakness[i].setSize(50, 50);
                            if (i > 11) {
                                weakness[i].setLocation(555, 35 + (55 * (i - 12)));
                            } else if (i > 5) {
                                weakness[i].setLocation(310, 35 + (55 * (i - 6)));
                            } else {
                                weakness[i].setLocation(65, 35 + (55 * i));
                            }
                            panel2.add(weakness[i]);
                            panel2.revalidate();
                            panel2.repaint();
                        }
                    }
                }
            }
        });
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pokedexList="";

                for (int i=0; i<Pokemon.pokedex.size();i++){
                    pokedexList=pokedexList.concat(Pokemon.pokedex.get(i).toString());
                    pokedexList=pokedexList.concat("///\n");
                }

                        File saveFile=new File("saveFile.txt");
                        try {
                            FileWriter fw=new FileWriter(saveFile, false);
                            fw.write(pokedexList);
                            fw.close();
                            JOptionPane.showMessageDialog(frame3,"Success");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileDialog = new JFileChooser();
                fileDialog.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result =fileDialog.showOpenDialog(frame3);
                if(result ==JFileChooser.APPROVE_OPTION) {
                    File file = fileDialog.getSelectedFile();
                    try {
                        String fileInfo= Files.readString(file.toPath());

                        String[] pokemonInfo = fileInfo.split("///\n");
                        for (int i=0;i<pokemonInfo.length;i++){
                            if(pokemonInfo[i].contains("Red")) new Red(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Blue")) new Blue(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Yellow")) new Yellow(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Ruby")) new Ruby(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Sapphire")) new Sapphire(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Emerald")) new Emerald(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Gold")) new Gold(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Silver")) new Silver(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Crystal")) new Crystal(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Pearl")) new Pearl(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Diamond")) new Diamond(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Platinum")) new Platinum(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Black")) new Black(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("Black2")) new Black2(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("White")) new White(pokemonInfo[i]);
                            else if(pokemonInfo[i].contains("White2")) new White2(pokemonInfo[i]);
                            else{
                                JOptionPane.showMessageDialog(panel, ("Error in a save file: line"+(i*12+1)));
                                continue;
                            }
                        }
                        System.out.println(Pokemon.pokedex);
                        DefaultListModel<String> d=new DefaultListModel<>();
                        for(int i=0;i<Pokemon.pokedex.size();i++){
                            d.addElement(Pokemon.pokedex.get(i).name);
                        }
                        if(list!=null)SP.remove(list);
                        if(SP!=null) panel.remove(SP);

                        list = new JList(d);
                        list.addListSelectionListener(new ListSelectionListener() {
                            @Override
                            public void valueChanged(ListSelectionEvent e) {
                                if (!e.getValueIsAdjusting()) {
                                    if(!list.isSelectionEmpty()) {
                                        String name = list.getSelectedValue();
                                        String[] info = Pokemon.pokedex.get(Pokemon.getIndex(name)).toString().split("\n");
                                        if (tName == null) tName = new JLabel();
                                        tName.setText(name);
                                        tName.setSize(55, 15);
                                        tName.setLocation(510, 5);
                                        panel1.add(tName);
                                        if (tHP == null) tHP = new JLabel();
                                        tHP.setText(info[1]);
                                        tHP.setLocation(510, 85);
                                        tHP.setSize(55, 15);
                                        panel1.add(tHP);
                                        if (tAttack == null) tAttack = new JLabel();
                                        tAttack.setText(info[2]);
                                        tAttack.setLocation(510, 100);
                                        tAttack.setSize(55, 15);
                                        panel1.add(tAttack);
                                        if (tSpeed == null) tSpeed = new JLabel();
                                        tSpeed.setText(info[3]);
                                        tSpeed.setLocation(510, 115);
                                        tSpeed.setSize(55, 15);
                                        panel1.add(tSpeed);
                                        if (tDefense == null) tDefense = new JLabel();
                                        tDefense.setText(info[4]);
                                        tDefense.setLocation(510, 130);
                                        tDefense.setSize(55, 15);
                                        panel1.add(tDefense);
                                        if (tGeneration == null) tGeneration = new JLabel();
                                        tGeneration.setText(info[7]);
                                        tGeneration.setLocation(510, 180);
                                        tGeneration.setSize(55, 15);
                                        panel1.add(tGeneration);
                                        if (tGV == null) tGV = new JLabel();
                                        tGV.setText(info[8]);
                                        tGV.setLocation(510, 210);
                                        tGV.setSize(55, 15);
                                        panel1.add(tGV);
                                        if (tType1 == null) tType1 = new JLabel();
                                        String[] types = info[5].split("/");
                                        tType1.setIcon(new ImageIcon("src\\" + types[0] + ".png"));
                                        tType1.setLocation(590, 5);
                                        tType1.setSize(50, 50);
                                        panel1.add(tType1);
                                        if (info[5].contains("/")) {
                                            if (tType2 == null) tType2 = new JLabel();
                                            tType2.setIcon(new ImageIcon("src\\" + types[1] + ".png"));
                                            tType2.setLocation(645, 5);
                                            tType2.setSize(50, 50);
                                            panel1.add(tType2);
                                        } else {
                                            if (tType2 != null) panel1.remove(tType2);
                                        }
                                        if (tPicture == null) tPicture = new JLabel();
                                        tPicture.setIcon(new ImageIcon(info[10]));
                                        tPicture.setLocation(5, 5);
                                        tPicture.setSize(360, 240);
                                        panel1.add(tPicture);
                                        if (tDescription == null) tDescription = new JTextArea();
                                        tDescription.setSize(720, 145);
                                        tDescription.setLocation(5, 270);
                                        tDescription.setEditable(false);
                                        tDescription.setLineWrap(true);
                                        tDescription.setText(info[9]);
                                        panel1.add(tDescription);
                                        if (tRegion == null) tRegion = new JLabel();
                                        tRegion.setText(info[6]);
                                        tRegion.setSize(55, 15);
                                        tRegion.setLocation(510, 240);
                                        panel1.add(tRegion);

                                        for (int i = 0; i < 18; i++) {
                                            Pokemon.add_types_weaknesses();
                                            String value = "" + Pokemon.pokedex.get(Pokemon.getIndex(name)).weaknesses[i];
                                            if (weakness[i] == null) weakness[i] = new JLabel();
                                            weakness[i].setText(value);
                                            weakness[i].setSize(50, 50);
                                            if (i > 11) {
                                                weakness[i].setLocation(555, 35 + (55 * (i - 12)));
                                            } else if (i > 5) {
                                                weakness[i].setLocation(310, 35 + (55 * (i - 6)));
                                            } else {
                                                weakness[i].setLocation(65, 35 + (55 * i));
                                            }
                                            panel2.add(weakness[i]);
                                            panel2.revalidate();
                                            panel2.repaint();
                                        }
                                    }
                                }
                            }
                        });
                        JScrollPane SP = new JScrollPane(list);
                        SP.setLocation(775,50);
                        SP.setSize(290,450);
                        SP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        panel.add(SP);

                        frame3.revalidate();
                        frame3.repaint();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        });
        releaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(panel1,"Choose a Pokemon first!");
                }
                else {

                    Pokemon.pokedex.remove(Pokemon.pokedex.get(Pokemon.getIndex(list.getSelectedValue())));
                    System.out.println(Pokemon.pokedex);

                    frame3.dispose();
                    createFrame3();

                    DefaultListModel<String> d=new DefaultListModel<>();
                    for(int i=0;i<Pokemon.pokedex.size();i++){
                        d.addElement(Pokemon.pokedex.get(i).name);
                    }
                    JList<String> list = new JList(d);
                    list.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting()) {
                                if(!list.isSelectionEmpty()) {
                                    String name = list.getSelectedValue();
                                    String[] info = Pokemon.pokedex.get(Pokemon.getIndex(name)).toString().split("\n");
                                    if (tName == null) tName = new JLabel();
                                    tName.setText(name);
                                    tName.setSize(55, 15);
                                    tName.setLocation(510, 5);
                                    panel1.add(tName);
                                    if (tHP == null) tHP = new JLabel();
                                    tHP.setText(info[1]);
                                    tHP.setLocation(510, 85);
                                    tHP.setSize(55, 15);
                                    panel1.add(tHP);
                                    if (tAttack == null) tAttack = new JLabel();
                                    tAttack.setText(info[2]);
                                    tAttack.setLocation(510, 100);
                                    tAttack.setSize(55, 15);
                                    panel1.add(tAttack);
                                    if (tSpeed == null) tSpeed = new JLabel();
                                    tSpeed.setText(info[3]);
                                    tSpeed.setLocation(510, 115);
                                    tSpeed.setSize(55, 15);
                                    panel1.add(tSpeed);
                                    if (tDefense == null) tDefense = new JLabel();
                                    tDefense.setText(info[4]);
                                    tDefense.setLocation(510, 130);
                                    tDefense.setSize(55, 15);
                                    panel1.add(tDefense);
                                    if (tGeneration == null) tGeneration = new JLabel();
                                    tGeneration.setText(info[7]);
                                    tGeneration.setLocation(510, 180);
                                    tGeneration.setSize(55, 15);
                                    panel1.add(tGeneration);
                                    if (tGV == null) tGV = new JLabel();
                                    tGV.setText(info[8]);
                                    tGV.setLocation(510, 210);
                                    tGV.setSize(55, 15);
                                    panel1.add(tGV);
                                    if (tType1 == null) tType1 = new JLabel();
                                    String[] types = info[5].split("/");
                                    tType1.setIcon(new ImageIcon("src\\" + types[0] + ".png"));
                                    tType1.setLocation(590, 5);
                                    tType1.setSize(50, 50);
                                    panel1.add(tType1);
                                    if (info[5].contains("/")) {
                                        if (tType2 == null) tType2 = new JLabel();
                                        tType2.setIcon(new ImageIcon("src\\" + types[1] + ".png"));
                                        tType2.setLocation(645, 5);
                                        tType2.setSize(50, 50);
                                        panel1.add(tType2);
                                    } else {
                                        if (tType2 != null) panel1.remove(tType2);
                                    }
                                    if (tPicture == null) tPicture = new JLabel();
                                    tPicture.setIcon(new ImageIcon(info[10]));
                                    tPicture.setLocation(5, 5);
                                    tPicture.setSize(360, 240);
                                    panel1.add(tPicture);
                                    if (tDescription == null) tDescription = new JTextArea();
                                    tDescription.setSize(720, 145);
                                    tDescription.setLocation(5, 270);
                                    tDescription.setEditable(false);
                                    tDescription.setLineWrap(true);
                                    tDescription.setText(info[9]);
                                    panel1.add(tDescription);
                                    if (tRegion == null) tRegion = new JLabel();
                                    tRegion.setText(info[6]);
                                    tRegion.setSize(55, 15);
                                    tRegion.setLocation(510, 240);
                                    panel1.add(tRegion);

                                    for (int i = 0; i < 18; i++) {
                                        Pokemon.add_types_weaknesses();
                                        String value = "" + Pokemon.pokedex.get(Pokemon.getIndex(name)).weaknesses[i];
                                        if (weakness[i] == null) weakness[i] = new JLabel();
                                        weakness[i].setText(value);
                                        weakness[i].setSize(50, 50);
                                        if (i > 11) {
                                            weakness[i].setLocation(555, 35 + (55 * (i - 12)));
                                        } else if (i > 5) {
                                            weakness[i].setLocation(310, 35 + (55 * (i - 6)));
                                        } else {
                                            weakness[i].setLocation(65, 35 + (55 * i));
                                        }
                                        panel2.add(weakness[i]);
                                        panel2.revalidate();
                                        panel2.repaint();
                                    }
                                }
                            }
                        }
                    });
                    JScrollPane SP = new JScrollPane(list);
                    SP.setLocation(775,50);
                    SP.setSize(290,450);
                    SP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    panel.add(SP);

                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!list.isSelectionEmpty()) {
                    Pokemon toChange = Pokemon.pokedex.get(Pokemon.getIndex(list.getSelectedValue()));
                    JOptionPane JOP = new JOptionPane();
                    toChange.name= JOptionPane.showInputDialog(panel2, "New name:");
                    System.out.println(Pokemon.pokedex);
                    frame3.dispose();
                    createFrame3();

                    DefaultListModel<String> d=new DefaultListModel<>();
                    for(int i=0;i<Pokemon.pokedex.size();i++){
                        d.addElement(Pokemon.pokedex.get(i).name);
                    }
                    JList<String> list = new JList(d);
                    list.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting()) {
                                if(!list.isSelectionEmpty()) {
                                    String name = list.getSelectedValue();
                                    String[] info = Pokemon.pokedex.get(Pokemon.getIndex(name)).toString().split("\n");
                                    if (tName == null) tName = new JLabel();
                                    tName.setText(name);
                                    tName.setSize(55, 15);
                                    tName.setLocation(510, 5);
                                    panel1.add(tName);
                                    if (tHP == null) tHP = new JLabel();
                                    tHP.setText(info[1]);
                                    tHP.setLocation(510, 85);
                                    tHP.setSize(55, 15);
                                    panel1.add(tHP);
                                    if (tAttack == null) tAttack = new JLabel();
                                    tAttack.setText(info[2]);
                                    tAttack.setLocation(510, 100);
                                    tAttack.setSize(55, 15);
                                    panel1.add(tAttack);
                                    if (tSpeed == null) tSpeed = new JLabel();
                                    tSpeed.setText(info[3]);
                                    tSpeed.setLocation(510, 115);
                                    tSpeed.setSize(55, 15);
                                    panel1.add(tSpeed);
                                    if (tDefense == null) tDefense = new JLabel();
                                    tDefense.setText(info[4]);
                                    tDefense.setLocation(510, 130);
                                    tDefense.setSize(55, 15);
                                    panel1.add(tDefense);
                                    if (tGeneration == null) tGeneration = new JLabel();
                                    tGeneration.setText(info[7]);
                                    tGeneration.setLocation(510, 180);
                                    tGeneration.setSize(55, 15);
                                    panel1.add(tGeneration);
                                    if (tGV == null) tGV = new JLabel();
                                    tGV.setText(info[8]);
                                    tGV.setLocation(510, 210);
                                    tGV.setSize(55, 15);
                                    panel1.add(tGV);
                                    if (tType1 == null) tType1 = new JLabel();
                                    String[] types = info[5].split("/");
                                    tType1.setIcon(new ImageIcon("src\\" + types[0] + ".png"));
                                    tType1.setLocation(590, 5);
                                    tType1.setSize(50, 50);
                                    panel1.add(tType1);
                                    if (info[5].contains("/")) {
                                        if (tType2 == null) tType2 = new JLabel();
                                        tType2.setIcon(new ImageIcon("src\\" + types[1] + ".png"));
                                        tType2.setLocation(645, 5);
                                        tType2.setSize(50, 50);
                                        panel1.add(tType2);
                                    } else {
                                        if (tType2 != null) panel1.remove(tType2);
                                    }
                                    if (tPicture == null) tPicture = new JLabel();
                                    tPicture.setIcon(new ImageIcon(info[10]));
                                    tPicture.setLocation(5, 5);
                                    tPicture.setSize(360, 240);
                                    panel1.add(tPicture);
                                    if (tDescription == null) tDescription = new JTextArea();
                                    tDescription.setSize(720, 145);
                                    tDescription.setLocation(5, 270);
                                    tDescription.setEditable(false);
                                    tDescription.setLineWrap(true);
                                    tDescription.setText(info[9]);
                                    panel1.add(tDescription);
                                    if (tRegion == null) tRegion = new JLabel();
                                    tRegion.setText(info[6]);
                                    tRegion.setSize(55, 15);
                                    tRegion.setLocation(510, 240);
                                    panel1.add(tRegion);

                                    for (int i = 0; i < 18; i++) {
                                        Pokemon.add_types_weaknesses();
                                        String value = "" + Pokemon.pokedex.get(Pokemon.getIndex(name)).weaknesses[i];
                                        if (weakness[i] == null) weakness[i] = new JLabel();
                                        weakness[i].setText(value);
                                        weakness[i].setSize(50, 50);
                                        if (i > 11) {
                                            weakness[i].setLocation(555, 35 + (55 * (i - 12)));
                                        } else if (i > 5) {
                                            weakness[i].setLocation(310, 35 + (55 * (i - 6)));
                                        } else {
                                            weakness[i].setLocation(65, 35 + (55 * i));
                                        }
                                        panel2.add(weakness[i]);
                                        panel2.revalidate();
                                        panel2.repaint();
                                    }
                                }
                            }
                        }
                    });
                    JScrollPane SP = new JScrollPane(list);
                    SP.setLocation(775,50);
                    SP.setSize(290,450);
                    SP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    panel.add(SP);

                    panel.revalidate();
                    panel.repaint();
                }
                else JOptionPane.showMessageDialog(panel1,"Choose a Pokemon first!");
            }
        });
    }

    public static void main(String[] args){
        createFrame1();
    }
}
