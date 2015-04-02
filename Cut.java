package ardygemstealer;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.wrappers.Item;

public class Cut implements Strategy {

	private int sapphire = 1624;
	private int dragonStone = 1632;
	private int emerald = 1622;
	private int chisel = 1756;
	private int ruby = 1620;
	private int cutRuby = 1604;
	private int cutDragonStone = 1616;
	private int cutEmerald = 1606;
	private int cutSapphire = 1608;
	Item[] cashPile = Inventory.getItems(996);

	@Override
	public boolean activate() {

		return Inventory.isFull();
	}

	@Override
	public void execute() {
		if (Inventory.getCount(996) >= 1) {
			Main.STATUS = "Storing Money!";
			Menu.sendAction(493, 995, cashPile[0].getSlot(), 3214);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(996) == 0;
				}
			}, 1570);
		}
		Main.STATUS = "Crafting!";
		if (Inventory.getCount(sapphire) >= 1
				|| Inventory.getCount(cutSapphire) >= 1) {
			Inventory.combine(chisel, sapphire);
			Inventory.combine(chisel, cutSapphire);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(sapphire) == 0
							|| Inventory.getCount(cutSapphire) == 0;
				}
			}, 25);

		}
		if (Inventory.getCount(dragonStone) >= 1
				|| Inventory.getCount(cutDragonStone) >= 1) {
			Inventory.combine(chisel, dragonStone);
			Inventory.combine(chisel, cutDragonStone);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(dragonStone) == 0
							|| Inventory.getCount(cutDragonStone) == 0;
				}
			}, 25);
		}
		if (Inventory.getCount(emerald) >= 1
				|| Inventory.getCount(cutEmerald) >= 1) {
			Inventory.combine(chisel, emerald);
			Inventory.combine(chisel, cutEmerald);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(emerald) == 0
							|| Inventory.getCount(cutEmerald) == 0;
				}
			}, 25);
		}
		if (Inventory.getCount(ruby) >= 1 || Inventory.getCount(cutRuby) >= 1) {
			Inventory.combine(chisel, ruby);
			Inventory.combine(chisel, cutRuby);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(ruby) == 0
							|| Inventory.getCount(cutRuby) == 0;
				}
			}, 25);
		}
	}

}