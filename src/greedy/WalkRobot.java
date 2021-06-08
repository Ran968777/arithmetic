package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 874. 模拟行走机器人
 *
 * @author Ran
 * @date 2021-06-07 11:14
 */
public class WalkRobot {
    HashSet<String> obs = new HashSet<>();
    int maxDistance = -1;

    /**
     * -2 ：向左转 90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动 x 个单位长度
     * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
     * 0 <= obstacles.length <= 104
     * cue:模拟: 每走一次,判断前方是否有障碍物, 若有,在前面停下,若没有,走到目的地, 计算距离
     * <p>
     * 计算距离的方式= (x-0)^2  + (y-0)^2 ([0,0]是原点)
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // 转化一维数组
        for (int i = 0; i < obstacles.length; i++) {
            int ox = obstacles[i][0];
            int oy = obstacles[i][1];
            obs.add(ox + "," + oy);
        }

        // 记录当前机器人的位置
        int x = 0, y = 0;
        // 记录机器人的朝向 1->北 ,2->东, 3->南, 4->西 , 默认是1
        int dir = 1;


        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            // 转向命令
            if (command == -2 || command == -1) {
                dir = turn(dir, command);
            } else {
                // 移动命令
                /**
                 * 移动命令的思路:
                 * 1.每次走一格,判断是否碰到障碍物 (obstacles数量大时且command小时,这个较好)
                 * 2.例如方向朝北, 当前的x是2, 拿到obstacles中所有x=2的点, 将y-command 若小于当前点的y,说明会碰到障碍物 (obstacles数量小时且command大时,这个较好,但是需要将点按x,y坐标归纳的map)
                 */
                while (command != 0) {
                    //移动,每次移动一格,如果碰到障碍物就停下.
                    if (dir == 1 && !contains(x, y + 1)) {
                        y += 1;
                    } else if (dir == 3 && !contains(x, y - 1)) {
                        y -= 1;
                    } else if (dir == 2 && !contains(x + 1, y)) {
                        x += 1;
                    } else if (dir == 4 && !contains(x - 1, y)) {
                        x -= 1;
                    } else {
                        // 碰到障碍物
                        break;
                    }
                    command--;
                }
                // 计算距离
                if ((x * x + y * y) > maxDistance) {
                    maxDistance = (x * x + y * y);
                }
            }
        }

        return maxDistance;
    }

    /**
     * 转向
     *
     * @param dir     当前的方法
     * @param command 命令
     * @return 转后的方向
     */
    public int turn(int dir, int command) {
        // 左转
        if (command == -2) {
            return dir == 1 ? 4 : dir - 1;
        } else if (command == -1) {
            return dir == 4 ? 1 : dir + 1;
        }
        return 0;
    }

    public boolean contains(int x, int y) {
        return obs.contains(x + "," + y);
    }

    public static void main(String[] args) {
        WalkRobot walkRobot = new WalkRobot();
        int[] commands = {4, -1, 3};
        int[][] o = new int[0][];
        int i = walkRobot.robotSim(commands, o);
        System.out.println(i);
    }
}
