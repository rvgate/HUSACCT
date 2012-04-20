/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package husacct.validate.presentation;

import husacct.validate.domain.validation.ViolationType;
import husacct.validate.domain.validation.ruletype.RuleType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jorik
 */
public class LanguageConfigurationPanel extends javax.swing.JPanel {

	private final ComboBoxTableModel ruletypeModel;
	private final ComboBoxTableModel violationtypeModel;
	private final String language;
	private final List<RuleType> ruletypes;

    /** Creates new form LanguageConfigurationPanel */
    public LanguageConfigurationPanel(String language, List<RuleType> ruletypes, String[] severityNames) {
		this.language = language;
		this.ruletypes = ruletypes;
		String[] ruletypeColumnNames = {"Ruletype", "Severity"};

		ruletypeModel = new ComboBoxTableModel(ruletypeColumnNames, 0,severityNames) {

			Class<?>[] types = new Class[]{
			java.lang.String.class, java.lang.String.class
			};
			boolean[] canEdit = new boolean[]{
				false, true
			};

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};

		String[] violationtypeModelHeaders = {"Violationtype", "Severity", "Active"};
		violationtypeModel = new ComboBoxTableModel(violationtypeModelHeaders, 0, severityNames) {

			Class<?>[] types = new Class[]{
				String.class, String.class, Boolean.class
			};
			boolean[] canEdit = new boolean[]{
				false, true, true
			};

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};

		initComponents();

		TableColumnModel tcm = ruletypeTable.getColumnModel();
		tcm.getColumn(1).setCellEditor(ruletypeModel.getEditor());

		LoadRuleTypes();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ruletypePanel = new javax.swing.JScrollPane();
        ruletypeTable = new javax.swing.JTable();
        violationtypePanel = new javax.swing.JScrollPane();
        violationtypeTable = new javax.swing.JTable();
        applyViolationTypes = new javax.swing.JButton();

        ruletypeTable.setAutoCreateRowSorter(true);
        ruletypeTable.setModel(ruletypeModel);
        ruletypeTable.setFillsViewportHeight(true);
        ruletypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ruletypeTableMouseClicked(evt);
            }
        });
        ruletypeTable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                ruletypeTableCaretPositionChanged(evt);
            }
        });
        ruletypeTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ruletypePropentyChange(evt);
            }
        });
        ruletypeTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ruletypeTableKeyPressed(evt);
            }
        });
        ruletypeTable.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                ruletypeTableVetoableChange(evt);
            }
        });
        ruletypePanel.setViewportView(ruletypeTable);

        violationtypeTable.setAutoCreateRowSorter(true);
        violationtypeTable.setModel(violationtypeModel);
        violationtypeTable.setFillsViewportHeight(true);
        violationtypeTable.getTableHeader().setReorderingAllowed(false);
        violationtypePanel.setViewportView(violationtypeTable);

        applyViolationTypes.setText("Apply");
        applyViolationTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyViolationTypesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ruletypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(violationtypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(applyViolationTypes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(violationtypePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyViolationTypes)
                .addContainerGap())
            .addComponent(ruletypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	private void ruletypePropentyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ruletypePropentyChange
	}//GEN-LAST:event_ruletypePropentyChange

	private void ruletypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ruletypeTableMouseClicked
		if (ruletypeTable.getSelectedRow() > -1) {
			loadViolationType((String) ruletypeModel.getValueAt(ruletypeTable.
					getSelectedRow(), 0));
		}
	}//GEN-LAST:event_ruletypeTableMouseClicked

	private void ruletypeTableCaretPositionChanged(//GEN-FIRST:event_ruletypeTableCaretPositionChanged
			java.awt.event.InputMethodEvent evt) {//GEN-HEADEREND:event_ruletypeTableCaretPositionChanged
	}//GEN-LAST:event_ruletypeTableCaretPositionChanged

	private void ruletypeTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ruletypeTableKeyPressed
		if (ruletypeTable.getSelectedRow() > -1) {
			loadViolationType((String) ruletypeModel.getValueAt(ruletypeTable.
					getSelectedRow(), 0));
		}
	}//GEN-LAST:event_ruletypeTableKeyPressed

	private void ruletypeTableVetoableChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_ruletypeTableVetoableChange
			throws java.beans.PropertyVetoException {//GEN-HEADEREND:event_ruletypeTableVetoableChange
	}//GEN-LAST:event_ruletypeTableVetoableChange

	private void applyViolationTypesActionPerformed(//GEN-FIRST:event_applyViolationTypesActionPerformed
			java.awt.event.ActionEvent evt) {//GEN-HEADEREND:event_applyViolationTypesActionPerformed
		//TODO: Fix the fetching of the ruletypes en put them in a list to return to the reposetory

		List<RuleType> ruletypes = new ArrayList<RuleType>();
		for (int i = 0; i < ruletypeModel.getRowCount(); i++) {
			List<ViolationType> violationtypes = new ArrayList<ViolationType>();
			for (int j = 0; j < violationtypeModel.getRowCount(); j++) {
				ViolationType vt = new ViolationType(language);
				vt.setActive((Boolean) violationtypeModel.getValueAt(j, 2));

				violationtypes.add(vt);
			}
		}

	}//GEN-LAST:event_applyViolationTypesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyViolationTypes;
    private javax.swing.JScrollPane ruletypePanel;
    private javax.swing.JTable ruletypeTable;
    private javax.swing.JScrollPane violationtypePanel;
    private javax.swing.JTable violationtypeTable;
    // End of variables declaration//GEN-END:variables

	private void LoadRuleTypes() {
		for (RuleType ruletype : ruletypes) {
			ruletypeModel.addRow(new Object[]{ruletype.getKey(), "Low"});
		}
	}

	private void loadViolationType(String ruletypeKey) {
		for (RuleType ruletype : ruletypes) {
			if (ruletype.getKey().equals(ruletypeKey)) {
				clearModel(violationtypeModel);
				for (ViolationType violationtype : ruletype.getViolationTypes()) {
					violationtypeModel.addRow(new Object[]{violationtype.
								getViolationtypeKey(), 1,
														   violationtype.
								isActive()});
				}
			}
		}
	}

	private void clearModel(ComboBoxTableModel model) {
		int rows = model.getRowCount();
		while (0 < rows) {
			model.removeRow(0);
			rows--;
		}
	}
}
