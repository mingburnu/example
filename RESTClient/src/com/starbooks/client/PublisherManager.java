package com.starbooks.client;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.starbooks.model.*;

import quick.dbtable.*;

public class PublisherManager extends JFrame
{
    static final long serialVersionUID = 2009L;

    private JPanel contentPane = null;

    private JPanel pnlFields = new JPanel();
    private JLabel lblName = new JLabel("Publisher Name");
    private JLabel lblID = new JLabel("Publisher ID");
    private JTextField txtName = new JTextField("");
    private JTextField txtID = new JTextField("");
    private JButton btnInsert = new JButton("Insert");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnFind = new JButton("Find");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnRefresh = new JButton("Refresh");

    private DBTable tblPublishers = new DBTable();
    private JScrollPane pnlGrids = new JScrollPane(tblPublishers);

    private JLabel lblStatus = new JLabel(" ");

    private PublisherDAO publisherDAO = new PublisherJDBCDAO();
//    private PublisherDAO publisherDAO = new PublisherRESTDAO();

    public PublisherManager()
    {
        GridLayout fieldsLayout = new GridLayout(6, 2);
        pnlFields.setLayout(fieldsLayout);

        pnlFields.add(lblID);
        pnlFields.add(btnInsert);
        pnlFields.add(txtID);
        pnlFields.add(btnFind);
        pnlFields.add(lblName);
        pnlFields.add(btnUpdate);
        pnlFields.add(txtName);
        pnlFields.add(btnDelete);
        pnlFields.add(new JLabel());
        pnlFields.add(btnRefresh);

        btnInsert.addActionListener(new PublisherInsertListener(this));
        btnDelete.addActionListener(new PublisherDeleteListener(this));
        btnFind.addActionListener(new PublisherFindListener(this));
        btnUpdate.addActionListener(new PublisherUpdateListener(this));
        btnRefresh.addActionListener(new PublisherRefreshListener(this));

        contentPane = (JPanel) this.getContentPane();
        contentPane.add(pnlFields, BorderLayout.NORTH);
        contentPane.add(pnlGrids, BorderLayout.CENTER);
        contentPane.add(lblStatus, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100, 100);
        this.setSize(800, 600);
        this.setTitle("Publisher Manager");
        this.setVisible(true);
    }

    public void insertActionPerformed(ActionEvent e)
    {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(txtID.getText());
        publisher.setPublisherName(txtName.getText());
        int updateCount = publisherDAO.insert(publisher);
        lblStatus.setText(updateCount + " row inserted.");
        this.btnRefresh.doClick();
    }

    public void deleteActionPerformed(ActionEvent e)
    {
        int updateCount = publisherDAO.delete(txtID.getText());
        lblStatus.setText(updateCount + " row deleted.");
        this.btnRefresh.doClick();
    }

    public void findActionPerformed(ActionEvent e)
    {
        Publisher publisher = publisherDAO.findByPrimaryKey(txtID.getText());
        txtName.setText(publisher.getPublisherName());
        lblStatus.setText("1 row found.");
        this.btnRefresh.doClick();
    }

    public void updateActionPerformed(ActionEvent e)
    {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(txtID.getText());
        publisher.setPublisherName(txtName.getText());
        int updateCount = publisherDAO.update(publisher);
        lblStatus.setText(updateCount + " row updated.");
        this.btnRefresh.doClick();
    }

    public void refreshActionPerformed(ActionEvent e)
    {
        try
        {
            Collection<Publisher> publishers = publisherDAO.findAll();
            tblPublishers.refreshDataObject(publishers, null);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        lblStatus.setText("Datagrid refreshed.");
    }

    class PublisherInsertListener implements ActionListener
    {
        private PublisherManager frame;

        public PublisherInsertListener(PublisherManager frame)
        {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e)
        {
            frame.insertActionPerformed(e);
        }
    }

    class PublisherDeleteListener implements ActionListener
    {
        private PublisherManager frame;

        public PublisherDeleteListener(PublisherManager frame)
        {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e)
        {
            frame.deleteActionPerformed(e);
        }
    }

    class PublisherFindListener implements ActionListener
    {
        private PublisherManager frame;

        public PublisherFindListener(PublisherManager frame)
        {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e)
        {
            frame.findActionPerformed(e);
        }
    }

    class PublisherUpdateListener implements ActionListener
    {
        private PublisherManager frame;

        public PublisherUpdateListener(PublisherManager frame)
        {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e)
        {
            frame.updateActionPerformed(e);
        }
    }

    class PublisherRefreshListener implements ActionListener
    {
        private PublisherManager frame;

        public PublisherRefreshListener(PublisherManager frame)
        {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e)
        {
            frame.refreshActionPerformed(e);
        }
    }

    public static void main(String[] args)
    {
        new PublisherManager();
    }
}
