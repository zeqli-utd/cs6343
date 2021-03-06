/*******************************************************************************
 * Copyright (c) 2001, 2007 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Mathew A. Nelson
 *     - Initial API and implementation
 *     Luis Crespo
 *     - Added getCurrentScore()
 *     Flemming N. Larsen
 *     - Ported to Java 5
 *     - Renamed method names and removed unused methods
 *     - Ordered all methods more naturally
 *     - Added methods for getting current scores
 *******************************************************************************/
package robocode.peer;


/**
 * @author Mathew A. Nelson (original)
 * @author Luis Crespo (contributor)
 * @author Flemming N. Larsen (contributor)
 */
public class TeamStatistics implements ContestantStatistics {

	private TeamPeer teamPeer;

	public TeamStatistics(TeamPeer teamPeer) {
		this.teamPeer = teamPeer;
	}

	public double getTotalScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalScore();
		}
		return d;
	}

	public double getTotalSurvivalScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalSurvivalScore();
		}
		return d;
	}

	public double getTotalLastSurvivorBonus() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalLastSurvivorBonus();
		}
		return d;
	}

	public double getTotalBulletDamageScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalBulletDamageScore();
		}
		return d;
	}

	public double getTotalBulletKillBonus() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalBulletKillBonus();
		}
		return d;
	}

	public double getTotalRammingDamageScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalRammingDamageScore();
		}
		return d;
	}

	public double getTotalRammingKillBonus() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalRammingKillBonus();
		}
		return d;
	}

	public int getTotalFirsts() {
		int d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalFirsts();
		}
		return d;
	}

	public int getTotalSeconds() {
		int d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalSeconds();
		}
		return d;
	}

	public int getTotalThirds() {
		int d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getTotalThirds();
		}
		return d;
	}

	public double getCurrentScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getCurrentScore();
		}
		return d;
	}

	public double getCurrentSurvivalScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getCurrentSurvivalScore();
		}
		return d;
	}

	public double getCurrentBulletDamageScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getCurrentBulletDamageScore();
		}
		return d;
	}

	public double getCurrentBulletKillBonus() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getCurrentBulletKillBonus();
		}
		return d;
	}

	public double getCurrentRammingDamageScore() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getCurrentRammingDamageScore();
		}
		return d;
	}

	public double getCurrentRammingKillBonus() {
		double d = 0;

		for (RobotPeer teammate : teamPeer) {
			d += teammate.getRobotStatistics().getCurrentRammingKillBonus();
		}
		return d;
	}
}
