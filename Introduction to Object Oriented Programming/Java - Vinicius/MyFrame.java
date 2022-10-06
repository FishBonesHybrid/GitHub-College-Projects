//Name: Vinicius Parzanini
//Student Number: k00263592
//Function: Frame of the music
//Date: 12/04/2021

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MyFrame extends MusicPlayer implements ActionListener
{
    //Variables
    //Frame
    JFrame frame = new JFrame();

    //Total
    public double totalP = 0;
    private JLabel total;
    DecimalFormat df = new DecimalFormat("###.##");

    //Cart
    private JButton gocart;
    ImageIcon carrinho = new ImageIcon("cart.png");
    String[] responses = {"No, I don't have","Yes, I have the discount cupon"};

    //Metallica Variables
    private JButton mea;
    private JButton mek;
    private JLabel mes;
    private JLabel mec;
    private double pricemeta = 9.99;
    private int metacart = 0;
    private int stockmeta = 9;

    //Ed Sheeran Variables
    private JButton eda;
    private JButton edk;
    private JLabel eds;
    private JLabel edc;
    private double edprice = 12.99;
    private int edcart = 0;
    private int stocked = 7;

    //Calvin Harris Variables
    private JButton caa;
    private JButton cak;
    private JLabel cas;
    private JLabel cac;
    private double calprice = 8.99;
    private int calcart = 0;
    private int stockcal = 10;

    //Stromae Variables
    private JButton sta;
    private JButton stk;
    private JLabel sts;
    private JLabel stc;
    private double stroprice = 8.99;
    private int strocart = 0;
    private int strostock = 8;

    //Maroon 5 Variables
    private JButton maa;
    private JButton mak;
    private JLabel mas;
    private JLabel mac;
    private double maprice = 7.99;
    private int macart = 0;
    private int mastock = 6;

    //Aerosmith Variables
    private JButton aea;
    private JButton aek;
    private JLabel aes;
    private JLabel aec;
    private double aeprice = 10.99;
    private int aecart = 0;
    private int aestock = 9;

    //Guns and Roses Variables
    private JButton gaa;
    private JButton gak;
    private JLabel gus;
    private JLabel guc;
    private double guprice = 6.99;
    private int gucart = 0;
    private int gustock = 10;

    //Justin Bieber Variables
    private JButton jua;
    private JButton juk;
    private JLabel juss;
    private JLabel juc;
    private double juprice = 13.99;
    private int jucart = 0;
    private int justock = 5;

    MyFrame()
    {
        //Border
        Border border = BorderFactory.createLineBorder(Color.black, 1);

        //Images of the albuns
        ImageIcon metallica = new ImageIcon("Metallica.jpg");
        ImageIcon ed = new ImageIcon("Ed.jpg");
        ImageIcon calvin = new ImageIcon("Calvin.png");
        ImageIcon stromae = new ImageIcon("Cheese.jpg");
        ImageIcon maroon = new ImageIcon("V.png");
        ImageIcon aero = new ImageIcon("Aero.jpg");
        ImageIcon guns = new ImageIcon("Guns.jpg");
        ImageIcon just = new ImageIcon("Justin.jpg");
        
        //Play Button
        ImageIcon play = new ImageIcon("play.png");

        frame.setSize(900, 600);
        frame.setTitle("iVinnie Music Player");
        frame.setResizable(false);//Doesn't allow the user to Resize the panel.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //This is setting the icon into the frame
        ImageIcon logo = new ImageIcon("Logo.png");
        frame.setIconImage(logo.getImage());

        //Changing the background color of the frame
        frame.getContentPane().setBackground(new Color(0xC2FFF8));

        //Messages in the shopping panel
        //Header
        JLabel header = new JLabel();
        header.setText("What album would you like to buy?");
        header.setHorizontalTextPosition(JLabel.CENTER);
        header.setVerticalTextPosition(JLabel.TOP);
        header.setFont(new Font("Roboto",Font.BOLD,15));
        header.setBounds(310, 0, 400, 30);

        //Footer
        JLabel footer = new JLabel();
        footer.setText("iVinnie Music Player 2021, All rights reserved");
        footer.setHorizontalTextPosition(JLabel.CENTER);
        footer.setVerticalTextPosition(JLabel.BOTTOM);
        footer.setVerticalAlignment(JLabel.BOTTOM);
        footer.setHorizontalAlignment(JLabel.CENTER);
        footer.setFont(new Font("Roboto",Font.BOLD,9));
        footer.setBounds(240, 540, 400, 30);

        //Total
        total = new JLabel();
        total.setText("Total: " + df.format(totalP) + "€");
        total.setFont(new Font("Montserrat",Font.BOLD,12));
        total.setBounds(680, 510, 130, 30);

        //Go to cart
        gocart = new JButton();
        gocart.setText("Go to cart");
        gocart.setFont(new Font("Montserrat",Font.PLAIN,12));
        gocart.setBounds(780, 510, 100, 30);
        gocart.setFocusable(false);
        gocart.addActionListener(this);

        // -------------------------------------------------------
        //Metallica
        JLabel metal = new JLabel();
        metal.setIcon(metallica);
        metal.setBounds(20, 40, 50, 50);
        metal.setBorder(border);

        //Description
        JLabel metald = new JLabel();
        metald.setText("Album: ...And justice for all, By Metallica, 9 Tracks, 1988");
        metald.setFont(new Font("Montserrat",Font.PLAIN,12));
        metald.setBounds(80, 40, 350, 50);

        //Play Demo
        JButton mep = new JButton();
        mep.setBounds(510, 55, 100, 20);
        mep.setText("Play Demo");
        mep.setFont(new Font("Montserrat",Font.PLAIN,12));
        mep.setFocusable(false);
        mep.setIcon(play);
        
        //Stock
        mes = new JLabel();
        mes.setText("Stock: " + stockmeta);
        mes.setBounds(620, 55, 80, 20);
        mes.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel mer = new JLabel();
        mer.setText(pricemeta + "€");
        mer.setBounds(700, 55, 50, 20);
        mer.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        mec = new JLabel();
        mec.setText(metacart + "");
        mec.setBounds(760, 55, 50, 20);
        mec.setFont(new Font("Montserrat",Font.PLAIN,12));
    
        //add to the cart
        mea = new JButton();
        mea.setBounds(800, 55, 20, 20);
        mea.setText("+");
        mea.setFont(new Font("Montserrat",Font.BOLD,15));
        mea.setFocusable(false);
        mea.addActionListener(this);

        //removing from the cart
        mek = new JButton();
        mek.setBounds(840, 55, 20, 20);
        mek.setText("-");
        mek.setFont(new Font("Montserrat",Font.BOLD,15));
        mek.setFocusable(false);
        mek.addActionListener(this);

        // ---------------------------------------------
        //Ed Sheeran
        JLabel edd = new JLabel();
        edd.setIcon(ed);
        edd.setBounds(20, 100, 50, 50);
        edd.setBorder(border);

        //Description
        JLabel eddd = new JLabel();
        eddd.setText("Album: Divide (Deluxe), By Ed Sheeran, 16 Tracks, 2017");
        eddd.setFont(new Font("Montserrat",Font.PLAIN,12));
        eddd.setBounds(80, 100, 350, 50);

        //Play Demo
        JButton edp = new JButton();
        edp.setBounds(510, 115, 100, 20);
        edp.setText("Play Demo");
        edp.setFont(new Font("Montserrat",Font.PLAIN,12));
        edp.setFocusable(false);
        edp.setIcon(play);

        //Stock
        eds = new JLabel();
        eds.setText("Stock: " + stocked);
        eds.setBounds(620, 115, 80, 20);
        eds.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel edr = new JLabel();
        edr.setText(edprice + "€");
        edr.setBounds(700, 115, 50, 20);
        edr.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        edc = new JLabel();
        edc.setText("" + edcart);
        edc.setBounds(760, 115, 50, 20);
        edc.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        eda = new JButton();
        eda.setBounds(800, 115, 20, 20);
        eda.setText("+");
        eda.setFont(new Font("Montserrat",Font.BOLD,15));
        eda.setFocusable(false);
        eda.addActionListener(this);

        //removing from the cart
        edk = new JButton();
        edk.setBounds(840, 115, 20, 20);
        edk.setText("-");
        edk.setFont(new Font("Montserrat",Font.BOLD,15));
        edk.setFocusable(false);
        edk.addActionListener(this);

        // ---------------------------------------------
        //Calvin Harris
        JLabel cal = new JLabel();
        cal.setIcon(calvin);
        cal.setBounds(20, 160, 50, 50);
        cal.setBorder(border);

        //Description
        JLabel cald = new JLabel();
        cald.setText("Album: Motion, By Calvin Harris, 15 Tracks, 2014");
        cald.setFont(new Font("Montserrat",Font.PLAIN,12));
        cald.setBounds(80, 160, 350, 50);

        //Play Demo
        JButton cap = new JButton();
        cap.setBounds(510, 175, 100, 20);
        cap.setText("Play Demo");
        cap.setFont(new Font("Montserrat",Font.PLAIN,12));
        cap.setFocusable(false);
        cap.setIcon(play);
        
        //Stock
        cas = new JLabel();
        cas.setText("Stock: " + stockcal);
        cas.setBounds(620, 175, 80, 20);
        cas.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel car = new JLabel();
        car.setText(calprice + "€");
        car.setBounds(700, 175, 50, 20);
        car.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        cac = new JLabel();
        cac.setText(calcart + "");
        cac.setBounds(760, 175, 50, 20);
        cac.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        caa = new JButton();
        caa.setBounds(800, 175, 20, 20);
        caa.setText("+");
        caa.setFont(new Font("Montserrat",Font.BOLD,15));
        caa.setFocusable(false);
        caa.addActionListener(this);

        //removing from the cart
        cak = new JButton();
        cak.setBounds(840, 175, 20, 20);
        cak.setText("-");
        cak.setFont(new Font("Montserrat",Font.BOLD,15));
        cak.setFocusable(false);
        cak.addActionListener(this);

        // ---------------------------------------------
        //Stromae
        JLabel stro = new JLabel();
        stro.setIcon(stromae);
        stro.setBounds(20, 220, 50, 50);
        stro.setBorder(border);

        //Description
        JLabel strod = new JLabel();
        strod.setText("Album: Cheese, By Stromae, 12 Tracks, 2010");
        strod.setFont(new Font("Montserrat",Font.PLAIN,12));
        strod.setBounds(80, 220, 350, 50);

        //Play Demo
        JButton stp = new JButton();
        stp.setBounds(510, 235, 100, 20);
        stp.setText("Play Demo");
        stp.setFont(new Font("Montserrat",Font.PLAIN,12));
        stp.setFocusable(false);
        stp.setIcon(play);

        //Stock
        sts = new JLabel();
        sts.setText("Stock: " + strostock);
        sts.setBounds(620, 235, 80, 20);
        sts.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel str = new JLabel();
        str.setText(stroprice + "€");
        str.setBounds(700, 235, 50, 20);
        str.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        stc = new JLabel();
        stc.setText("" + strocart);
        stc.setBounds(760, 235, 50, 20);
        stc.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        sta = new JButton();
        sta.setBounds(800, 235, 20, 20);
        sta.setText("+");
        sta.setFont(new Font("Montserrat",Font.BOLD,15));
        sta.setFocusable(false);
        sta.addActionListener(this);

        //removing from the cart
        stk = new JButton();
        stk.setBounds(840, 235, 20, 20);
        stk.setText("-");
        stk.setFont(new Font("Montserrat",Font.BOLD,15));
        stk.setFocusable(false);
        stk.addActionListener(this);

        // ---------------------------------------------
        //Maroon 5
        JLabel maro = new JLabel();
        maro.setIcon(maroon);
        maro.setBounds(20, 280, 50, 50);
        maro.setBorder(border);

        //Description
        JLabel marod = new JLabel();
        marod.setText("Album: V, By Maroon 5, 12 Tracks, 2014");
        marod.setFont(new Font("Montserrat",Font.PLAIN,12));
        marod.setBounds(80, 280, 350, 50);

        //Play Demo
        JButton map = new JButton();
        map.setBounds(510, 295, 100, 20);
        map.setText("Play Demo");
        map.setFont(new Font("Montserrat",Font.PLAIN,12));
        map.setFocusable(false);
        map.setIcon(play);

        //Stock
        mas = new JLabel();
        mas.setText("Stock: " + mastock);
        mas.setBounds(620, 295, 80, 20);
        mas.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel mar = new JLabel();
        mar.setText(maprice + "€");
        mar.setBounds(700, 295, 50, 20);
        mar.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        mac = new JLabel();
        mac.setText(macart + "");
        mac.setBounds(760, 295, 50, 20);
        mac.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        maa = new JButton();
        maa.setBounds(800, 295, 20, 20);
        maa.setText("+");
        maa.setFont(new Font("Montserrat",Font.BOLD,15));
        maa.setFocusable(false);
        maa.addActionListener(this);

        //removing from the cart
        mak = new JButton();
        mak.setBounds(840, 295, 20, 20);
        mak.setText("-");
        mak.setFont(new Font("Montserrat",Font.BOLD,15));
        mak.setFocusable(false);
        mak.addActionListener(this);

        // ---------------------------------------------
        //Aerosmith
        JLabel aer = new JLabel();
        aer.setIcon(aero);
        aer.setBounds(20, 340, 50, 50);
        aer.setBorder(border);

        //Description
        JLabel aerd = new JLabel();
        aerd.setText("Album: Get A Grip, By Aerosmith, 14 Tracks, 1993");
        aerd.setFont(new Font("Montserrat",Font.PLAIN,12));
        aerd.setBounds(80, 340, 350, 50);

        //Play Demo
        JButton aep = new JButton();
        aep.setBounds(510, 355, 100, 20);
        aep.setText("Play Demo");
        aep.setFont(new Font("Montserrat",Font.PLAIN,12));
        aep.setFocusable(false);
        aep.setIcon(play);

        //Stock
        aes = new JLabel();
        aes.setText("Stock: " + aestock);
        aes.setBounds(620, 355, 80, 20);
        aes.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel aerr = new JLabel();
        aerr.setText(aeprice + "€");
        aerr.setBounds(700, 355, 50, 20);
        aerr.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        aec = new JLabel();
        aec.setText(aecart + "");
        aec.setBounds(760, 355, 50, 20);
        aec.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        aea = new JButton();
        aea.setBounds(800, 355, 20, 20);
        aea.setText("+");
        aea.setFont(new Font("Montserrat",Font.BOLD,15));
        aea.setFocusable(false);
        aea.addActionListener(this);
        
        //removing from the cart
        aek = new JButton();
        aek.setBounds(840, 355, 20, 20);
        aek.setText("-");
        aek.setFont(new Font("Montserrat",Font.BOLD,15));
        aek.setFocusable(false);
        aek.addActionListener(this);

        // ---------------------------------------------
        //Guns and Roses
        JLabel gun = new JLabel();
        gun.setIcon(guns);
        gun.setBounds(20, 400, 50, 50);
        gun.setBorder(border);

        //Description
        JLabel gund = new JLabel();
        gund.setText("Album: Appetite For Destruction, By Guns 'n' Roses, 12 Tracks, 1987");
        gund.setFont(new Font("Montserrat",Font.PLAIN,12));
        gund.setBounds(80, 400, 410, 50);

        //Play Demo
        JButton gup = new JButton();
        gup.setBounds(510, 415, 100, 20);
        gup.setText("Play Demo");
        gup.setFont(new Font("Montserrat",Font.PLAIN,12));
        gup.setFocusable(false);
        gup.setIcon(play);

        //Stock
        gus = new JLabel();
        gus.setText("Stock: " + gustock);
        gus.setBounds(620, 415, 80, 20);
        gus.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel gur = new JLabel();
        gur.setText(guprice + "€");
        gur.setBounds(700, 415, 50, 20);
        gur.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        guc = new JLabel();
        guc.setText(gucart + "");
        guc.setBounds(760, 415, 50, 20);
        guc.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        gaa = new JButton();
        gaa.setBounds(800, 415, 20, 20);
        gaa.setText("+");
        gaa.setFont(new Font("Montserrat",Font.BOLD,15));
        gaa.setFocusable(false);
        gaa.addActionListener(this);

        //removing from the cart
        gak = new JButton();
        gak.setBounds(840, 415, 20, 20);
        gak.setText("-");
        gak.setFont(new Font("Montserrat",Font.BOLD,15));
        gak.setFocusable(false);
        gak.addActionListener(this);

        // ---------------------------------------------
        //Justin Bieber
        JLabel jus = new JLabel();
        jus.setIcon(just);
        jus.setBounds(20, 460, 50, 50);
        jus.setBorder(border);

        //Description
        JLabel jusd = new JLabel();
        jusd.setText("Album: Changes, By Justin Bieber, 17 Tracks, 2020");
        jusd.setFont(new Font("Montserrat",Font.PLAIN,12));
        jusd.setBounds(80, 460, 350, 50);

        //Play Demo
        JButton jup = new JButton();
        jup.setBounds(510, 475, 100, 20);
        jup.setText("Play Demo");
        jup.setFont(new Font("Montserrat",Font.PLAIN,12));
        jup.setFocusable(false);
        jup.setIcon(play);

        //Stock
        juss = new JLabel();
        juss.setText("Stock: " + justock);
        juss.setBounds(620, 475, 80, 20);
        juss.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Price
        JLabel jur = new JLabel();
        jur.setText(juprice + "€");
        jur.setBounds(700, 475, 50, 20);
        jur.setFont(new Font("Montserrat",Font.PLAIN,12));

        //Quantity on cart
        juc = new JLabel("0");
        juc.setText(jucart + "");
        juc.setBounds(760, 475, 50, 20);
        juc.setFont(new Font("Montserrat",Font.PLAIN,12));

        //add to the cart
        jua = new JButton();
        jua.setBounds(800, 475, 20, 20);
        jua.setText("+");
        jua.setFont(new Font("Montserrat",Font.BOLD,15));
        jua.setFocusable(false);
        jua.addActionListener(this);

        //removing from the cart
        juk = new JButton();
        juk.setBounds(840, 475, 20, 20);
        juk.setText("-");
        juk.setFont(new Font("Montserrat",Font.BOLD,15));
        juk.setFocusable(false);
        juk.addActionListener(this);

        // ---------------------------------------------
        //Adding to the panel
        //This one is to display the bounds
        frame.setLayout(null);

        //Header, Footer, total and go to cart
        frame.add(header);
        frame.add(footer); 
        frame.add(total);
        frame.add(gocart);

        //Metallica
        frame.add(metal);
        frame.add(metald);
        frame.add(mep);
        frame.add(mes);
        frame.add(mer);
        frame.add(mec);
        frame.add(mea);
        frame.add(mek);

        //Ed Sheeran
        frame.add(edd);
        frame.add(eddd);
        frame.add(edp);
        frame.add(eds);
        frame.add(edr);
        frame.add(edc);
        frame.add(eda);
        frame.add(edk);
        
        //Calvin Harris
        frame.add(cal);
        frame.add(cald);
        frame.add(cap);
        frame.add(cas);
        frame.add(car);
        frame.add(cac);
        frame.add(caa);
        frame.add(cak);

        //Stromae
        frame.add(stro);
        frame.add(strod);
        frame.add(stp);
        frame.add(sts);
        frame.add(str);
        frame.add(stc);
        frame.add(sta);
        frame.add(stk);

        //Maroon 5
        frame.add(maro);
        frame.add(marod);
        frame.add(map);
        frame.add(mas);
        frame.add(mar);
        frame.add(mac);
        frame.add(maa);
        frame.add(mak);

        //Aerosmith
        frame.add(aer);
        frame.add(aerd);
        frame.add(aep);
        frame.add(aes);
        frame.add(aerr);
        frame.add(aec);
        frame.add(aea);
        frame.add(aek);

        //Guns and Roses
        frame.add(gun);
        frame.add(gund);
        frame.add(gup);
        frame.add(gus);
        frame.add(gur);
        frame.add(guc);
        frame.add(gaa);
        frame.add(gak);

        //Justin Bieber
        frame.add(jus);
        frame.add(jusd);
        frame.add(jup);
        frame.add(juss);
        frame.add(jur);
        frame.add(juc);
        frame.add(jua);
        frame.add(juk);
        //frame.pack();

        //Make the frame visible, has to be in the end, otherwise nothing happens
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        //Metallica actionPerformed
        if(e.getSource() == mea)
        {
            if(stockmeta > 0 && stockmeta < 10)
            {
                totalP = totalP + pricemeta;
                total.setText("Total: " + df.format(totalP) + "€");
                metacart = metacart + 1;
                mec.setText(metacart + "");
                stockmeta = stockmeta - 1;
                mes.setText("Stock: " + stockmeta);
            }
        }
        if(e.getSource() == mek)
        {
            if(metacart > 0 && metacart < 10)
            {
                totalP = totalP - pricemeta;
                total.setText("Total: " + df.format(totalP) + "€");
                metacart = metacart - 1;
                mec.setText(metacart + "");
                stockmeta = stockmeta + 1;
                mes.setText("Stock: " + stockmeta);
            }
        }

        //---------------------------
        //ED Sheeran actionPerformed
        if(e.getSource() == eda)
        {
            if(stocked > 0 && stocked < 8)
            {
                totalP = totalP + edprice;
                total.setText("Total: " + df.format(totalP) + "€");
                edcart = edcart + 1;
                edc.setText(edcart + "");
                stocked = stocked - 1;
                eds.setText("Stock: " + stocked);
            }
        }
        if(e.getSource() == edk)
        {
            if(edcart > 0 && edcart < 8)
            {
                totalP = totalP - edprice;
                total.setText("Total: " + df.format(totalP) + "€");
                edcart = edcart - 1;
                edc.setText(edcart + "");
                stocked = stocked + 1;
                eds.setText("Stock: " + stocked);
            }
        }

        //---------------------------
        //Calvin Harris actionPerformed
        if(e.getSource() == caa)
        {
            if(stockcal > 0 && stockcal < 11)
            {
                totalP = totalP + calprice;
                total.setText("Total: " + df.format(totalP) + "€");
                calcart = calcart + 1;
                cac.setText(calcart + "");
                stockcal = stockcal - 1;
                cas.setText("Stock: " + stockcal);
            }
        }
        if(e.getSource() == cak)
        {
            if(calcart > 0 && calcart < 11)
            {
                totalP = totalP - calprice;
                total.setText("Total: " + df.format(totalP) + "€");
                calcart = calcart - 1;
                cac.setText(calcart + "");
                stockcal = stockcal + 1;
                cas.setText("Stock: " + stockcal);
            }
        }

        //---------------------------
        //Stromae actionPerformed
        if(e.getSource() == sta)
        {
            if(strostock > 0 && strostock < 11)
            {
                totalP = totalP + stroprice;
                total.setText("Total: " + df.format(totalP) + "€");
                strocart = strocart + 1;
                stc.setText(strocart + "");
                strostock = strostock - 1;
                sts.setText("Stock: " + strostock);
            }
        }
        if(e.getSource() == stk)
        {
            if(strocart > 0 && strocart < 11)
            {
                totalP = totalP - stroprice;
                total.setText("Total: " + df.format(totalP) + "€");
                strocart = strocart - 1;
                stc.setText(strocart + "");
                strostock = strostock + 1;
                sts.setText("Stock: " + strostock);
            }
        }

        //---------------------------
        //Maroon 5 actionPerformed
        if(e.getSource() == maa)
        {
            if(mastock > 0 && mastock < 7)
            {
                totalP = totalP + maprice;
                total.setText("Total: " + df.format(totalP) + "€");
                macart = macart + 1;
                mac.setText(macart + "");
                mastock = mastock - 1;
                mas.setText("Stock: " + mastock);
            }
        }
        if(e.getSource() == mak)
        {
            if(macart > 0 && macart < 7)
            {
                totalP = totalP - maprice;
                total.setText("Total: " + df.format(totalP) + "€");
                macart = macart - 1;
                mac.setText(macart + "");
                mastock = mastock + 1;
                mas.setText("Stock: " + mastock);
            }
        }

        //---------------------------
        //Aerosmith actionPerformed
        if(e.getSource() == aea)
        {
            if(aestock > 0 && aestock < 10)
            {
                totalP = totalP + aeprice;
                total.setText("Total: " + df.format(totalP) + "€");
                aecart = aecart + 1;
                aec.setText(aecart + "");
                aestock = aestock - 1;
                aes.setText("Stock: " + aestock);
            }
        }
        if(e.getSource() == aek)
        {
            if(aecart > 0 && aecart < 10)
            {
                totalP = totalP - aeprice;
                total.setText("Total: " + df.format(totalP) + "€");
                aecart = aecart - 1;
                aec.setText(aecart + "");
                aestock = aestock + 1;
                aes.setText("Stock: " + aestock);
            }
        }

        //---------------------------
        //Guns and Roses actionPerformed
        if(e.getSource() == gaa)
        {
            if(gustock > 0 && gustock < 11)
            {
                totalP = totalP + guprice;
                total.setText("Total: " + df.format(totalP) + "€");
                gucart = gucart + 1;
                guc.setText(gucart + "");
                gustock = gustock - 1;
                gus.setText("Stock: " + gustock);
            }
        }
        if(e.getSource() == gak)
        {
            if(gucart > 0 && gucart < 11)
            {
                totalP = totalP - guprice;
                total.setText("Total: " + df.format(totalP) + "€");
                gucart = gucart - 1;
                guc.setText(gucart + "");
                gustock = gustock + 1;
                gus.setText("Stock: " + gustock);
            }
        }

        //---------------------------
        //Justin Bieber actionPerformed
        if(e.getSource() == jua)
        {
            if(justock > 0 && justock < 6)
            {
                totalP = totalP + juprice;
                total.setText("Total: " + df.format(totalP) + "€");
                jucart = jucart + 1;
                juc.setText(jucart + "");
                justock = justock - 1;
                juss.setText("Stock: " + justock);
            }
        }
        if(e.getSource() == juk)
        {
            if(jucart > 0 && jucart < 6)
            {
                totalP = totalP - juprice;
                total.setText("Total: " + df.format(totalP) + "€");
                jucart = jucart - 1;
                juc.setText(jucart + "");
                justock = justock + 1;
                juss.setText("Stock: " + justock);
            }
        }

        //Opening cart
        if(e.getSource() == gocart)
        {
            //giving the option to the user if weather has the voucher cupom.
            int answer1 = JOptionPane.showOptionDialog(null, "That's your Total: " + df.format(totalP) + "€, Do you have the discount voucher?", "Your Cart", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, carrinho, responses, 0);
            if(answer1 == 1)
            {
                String vou = JOptionPane.showInputDialog(null,"What is your voucher code?", "Voucher Discount",JOptionPane.QUESTION_MESSAGE);
                if(vou.equals("vinnie"))
                {
                    //variables to perform the calculation
                    double sub = 0;
                    double discount = 0;
                    sub = (totalP / 100) * 20;
                    discount = totalP - sub;
                    JOptionPane.showMessageDialog(null, "Voucher accepted! Your discount is 20% of all your buys, now you pay " + df.format(discount) + "€", "Voucher Accepted", JOptionPane.INFORMATION_MESSAGE);

                    //Exit mensage
                    JOptionPane.showMessageDialog(null, "Thank you for your purchase, come back anytime!", "Thank you message", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Voucher Refused! try again your go to pay without voucher!", "Wrong voucher", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                //If the user doesn't have a voucher
                JOptionPane.showMessageDialog(null, "Ok! the total will be: " + df.format(totalP) + "€", "Total Cart to pay", JOptionPane.INFORMATION_MESSAGE);

                 //Exit mensage
                 JOptionPane.showMessageDialog(null, "Thank you for your purchase, come back anytime!", "Thank you message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
