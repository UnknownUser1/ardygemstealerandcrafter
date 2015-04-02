package ardygemstealer;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class Steal implements Strategy {
	SceneObject[] gemStall = SceneObjects.getNearest(2562);

	@Override
	public boolean activate() {

		return !Inventory.isFull();
	}

	@Override
	public void execute() {
		if (gemStall != null && gemStall.length > 0) {
			Main.STATUS = "Stealing!";
			gemStall[0].interact(1);
			Time.sleep(500);
		}
	}

}
