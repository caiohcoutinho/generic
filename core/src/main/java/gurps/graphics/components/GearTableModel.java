//package generic.graphics.components;
//
//import de.matthiasmann.twl.model.TableModel;
//import de.matthiasmann.twl.renderer.AnimationState.StateKey;
//import main.java.gurps.application.Label;
//import main.java.gurps.model.GearAttackOption;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Caio on 17/04/2015.
// */
//public class GearTableModel implements TableModel {
//
//    private List<GearAttackOption> options = new ArrayList<GearAttackOption>();
//
//    public GearTableModel(List<GearAttackOption> options) {
//        this.options = options;
//    }
//
//    public List<GearAttackOption> getOptions() {
//        return options;
//    }
//
//    public void setOptions(List<GearAttackOption> options) {
//        this.options = options;
//    }
//
//    public int getNumRows() {
//        return this.getOptions().size();
//    }
//
//    public Object getCell(int rowIndex, int columnIndex) {
//        GearAttackOption option = this.getOptions().get(rowIndex);
//        switch (columnIndex){
//            case 0:
//                return option.getAttackDamage();
//            case 1:
//                return option.getReach();
//            default:
//                throw new RuntimeException(String.format(Label.ERROR_INVALID_GEAR_TABLE_MODEL_COLUMN_INDEX,
//                        this.getNumRows(), columnIndex));
//        }
//    }
//
//    public Object getTooltipContent(int i, int i1) {
//        return null; // TODO: Implement this correctly.
//    }
//
//    public void addChangeListener(ChangeListener changeListener) {
//
//    }
//
//    public void removeChangeListener(ChangeListener changeListener) {
//
//    }
//
//    public int getNumColumns() {
//        return 2;
//    }
//
//    public StateKey[] getColumnHeaderStates() {
//        return new StateKey[0];
//    }
//
//    public String getColumnHeaderText(int columnIndex) {
//        switch (columnIndex){
//            case 0:
//                return Label.GEAR_ATTACK_OPTION_DAMAGE;
//            case 1:
//                return Label.GEAR_ATTACK_OPTION_REACH;
//            default:
//                throw new RuntimeException(String.format(Label.ERROR_INVALID_GEAR_TABLE_MODEL_COLUMN_INDEX,
//                        this.getNumColumns(), columnIndex));
//        }
//    }
//
//    public boolean getColumnHeaderState(int i, int i1) {
//        return false;
//    }
//}
