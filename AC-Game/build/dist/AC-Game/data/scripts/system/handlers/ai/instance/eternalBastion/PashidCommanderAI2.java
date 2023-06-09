/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, ragarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 
 * @-Aion-Unique-
 * @-Aion-Lightning
 * @Aion-Engine
 * @Aion-Extreme
 * @Aion-NextGen
 * @Aion-Core Dev.
 */
package ai.instance.eternalBastion;

import ai.AggressiveNpcAI2;
import com.aionemu.gameserver.ai2.AIName;
import com.aionemu.gameserver.skillengine.SkillEngine;
import com.aionemu.gameserver.utils.ThreadPoolManager;

/**
 * @author Alcapwnd
 */

@AIName("pashid_commander")
public class PashidCommanderAI2 extends AggressiveNpcAI2 {

    @Override
    protected void handleSpawned() {
        PashidSkill(3000);
        PashidSkill(6000);
        super.handleSpawned();
    }

    private void PashidFirstSkill(int skillId) {
        SkillEngine.getInstance().getSkill(getOwner(), skillId, 65, getOwner()).useNoAnimationSkill();
    }

    private void VritraLegionBless(int skillId) {
        SkillEngine.getInstance().getSkill(getOwner(), skillId, 65, getOwner()).useNoAnimationSkill();
    }

    private void PashidSkill(final int time) {
        ThreadPoolManager.getInstance().schedule(new Runnable() {

            @Override
            public void run() {
                if (time == 3000) {
                    VritraLegionBless(20700);
                }
                if (time == 6000) {
                    PashidFirstSkill(21237);
                }
            }
        }, time);
    }

    protected int getTalkDelay() {
        return getObjectTemplate().getTalkDelay() * 1000;
    }

}