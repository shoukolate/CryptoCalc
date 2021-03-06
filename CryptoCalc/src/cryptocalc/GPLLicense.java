/*****************************************************************************
 * src/GPLLicense.java: GPLv2 Viewer JFrame for CryptoCalc
 *****************************************************************************
 * Copyright (C) 2019 Shou
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *****************************************************************************/

package cryptocalc;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GPLLicense extends JFrame {
	JTextArea LicenseViewer;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPLLicense frame = new GPLLicense();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GPLLicense() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GPLLicense.class.getResource("/graphics/Icon.png")));
		setTitle("CryptoCalc's License");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 548, 468);
		contentPane.add(scrollPane);

		LicenseViewer = new JTextArea();
		LicenseViewer.setEditable(false);
		scrollPane.setViewportView(LicenseViewer);
		try {
			InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/licenses/gpl-2.0.txt"));
			LicenseViewer.read(reader, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
