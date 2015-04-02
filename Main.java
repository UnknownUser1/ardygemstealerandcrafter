package ardygemstealer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.*;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Skill;

@ScriptManifest(author = "Unknown User", category = Category.CRAFTING, description = "Request - Steals gems then cuts at ardy Gem Stall", name = "UThiev & Crafter", servers = { "Ikov" }, version = 1)
public class Main extends Script implements Paintable {

	public static String STATUS = "Enjoy!";
	public static long startTime;
	private static int newXp;
	private static int startingXp;
	private static int startingShards;
	private int[] shardId = { 9191, 9194, 9190, 9192 };
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public boolean onExecute() {
		startTime = System.currentTimeMillis();
		startingXp = Skill.CRAFTING.getExperience();
		newXp = Skill.THIEVING.getExperience();
		startingShards = Inventory.getCount(true, shardId);
		strategies.add(new Steal());
		strategies.add(new Cut());
		provide(strategies);

		return true;
	}

	public void onFinish() {
		System.out.println("Scriped Ended, Thanks for using!");
	}

	private final Color color1 = new Color(0, 51, 51);
	private final Color color2 = new Color(0, 0, 0);
	private final BasicStroke stroke1 = new BasicStroke(3);
	private final Font font1 = new Font("Tekton Pro Ext", 0, 22);
	private final Font font2 = new Font("Tekton Pro Ext", 0, 15);
	private final Font font3 = new Font("Tekton Pro Ext", 0, 18);

	public void paint(Graphics C) {
		Graphics2D g = (Graphics2D) C;
		g.setColor(color1);
		g.fillRoundRect(6, 344, 506, 129, 16, 16);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRoundRect(6, 344, 506, 129, 16, 16);
		g.setFont(font1);
		g.drawString("UThiever   &&   Crafter", 109, 368);
		g.setFont(font2);
		g.drawString("V 1.0", 463, 366);
		g.drawString("By - UnknownUser", 360, 468);
		g.setFont(font3);
		g.drawString("Run Time -", 10, 392);
		g.drawString("Craft Xp -", 9, 417);
		g.drawString("Thieving Xp -", 10, 445);
		g.drawString("Status -", 276, 393);
		g.drawString("Tips Made -", 277, 427);

		int TXP = Skill.getCurrentExperience(Skill.THIEVING.getIndex()) - newXp;
		int CXP = Skill.getCurrentExperience(Skill.CRAFTING.getIndex())
				- startingXp;
		int CC = Inventory.getCount(true, shardId) - startingShards;

		C.setColor(Color.BLACK);
		C.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		C.drawString(Variables.addDecimals(CC), 392, 427);
		C.drawString(STATUS, 365, 393);
		C.drawString(Variables.addDecimals(TXP), 130, 445);
		C.drawString(Variables.addDecimals(CXP), 110, 417);
		C.drawString(Variables.runTime(startTime), 115, 392);

	}
}
