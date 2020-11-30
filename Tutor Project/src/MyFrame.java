import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List list;
	PriorityQueue<Tutor> pq;
	List list_1;
	private JTextField txtassigned;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Name:");
		
		JPanel panel = new JPanel();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblModuleList = new JLabel("Module List");
		
		JButton btnNewButton = new JButton("GetTutor");

		
		JPanel panel_1 = new JPanel();
		
		JLabel lblFreeTutorsList = new JLabel("Free Tutors List");
		lblFreeTutorsList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblnamemoduledistanceratingstatus = new JLabel("(Name----------Module----------Distance----------Rating------------Status");
		
		JLabel lblAssignedTutor = new JLabel("Assigned Tutor:");
		
		txtassigned = new JTextField();
		txtassigned.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addComponent(lblModuleList))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeTutorsList)
							.addGap(140))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(166)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblnamemoduledistanceratingstatus)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAssignedTutor)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtassigned, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblFreeTutorsList))
					.addGap(5)
					.addComponent(lblnamemoduledistanceratingstatus)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblModuleList)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAssignedTutor)
						.addComponent(txtassigned, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		 list_1 = new List();
		panel_1.add(list_1, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		list = new List();
		list.add("Maths");
		list.add("Physics");
		list.add("Statistics");
		panel.add(list, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
		readFromFile();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				list_1.clear();
				readFromFile();
				txtassigned.removeAll();
				while(pq.isEmpty() == false)
				{
					Tutor t = pq.remove();
					//String sub = pq.remove().getModule();
					if(t.getModule().equalsIgnoreCase(list.getSelectedItem()))
						txtassigned.setText(t.getName());
				}
				
			}
		});
	}
	
	private void writeToFile(String line)
	{
		try {
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter("tutors.txt",true)));
			write.println(line);
			write.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void readFromFile()
	{
			File file = new File("tutors.txt");
		ArrayList<Tutor> l = new ArrayList();
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			while(input.hasNext())
			{
				String temp = input.nextLine();
				StringTokenizer tk = new StringTokenizer(temp,"//");
				Tutor ap = new Tutor();
				ap.setName(tk.nextToken());
				ap.setModule(tk.nextToken());
				ap.setDistance(Integer.parseInt(tk.nextToken()));
				ap.setRating(Integer.parseInt(tk.nextToken()));
				ap.setStatus(tk.nextToken());
				l.add(ap);
				list_1.add(ap.getName()+"--"+ap.getModule()+"--"+ap.getDistance()+"--"+ap.getRating()+"--"+ap.getStatus());
			}
			input.close();
			
			TutorComparator cmp = new TutorComparator();
			 pq = new PriorityQueue(cmp);
			for(Tutor a:l)
			{
				pq.add(a);
			}
			/*int i = 1;
			while(pq.size()!=0)
			{
				Task a = pq.remove();
				list.add(i+"."+"Name:"+a.getName()+", Rating:"+a.getRate()+", +Date:"+a.getDate()+", Type:"+a.getType());
				
				i++;
			}*/
		}
		
	}
}
