package com.company;
public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, -1, -1);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }


        public static class Robot {
            int X;
            int Y;
            Direction dir;

            public Robot(int X, int Y, Direction dir) {
                this.X = X;
                this.Y = Y;
                this.dir = dir;
            }

            public Direction getDirection() {
                // текущее направление взгляда
                return dir;
            }

            public int getX() {
                // текущая координата X
                return X;
            }

            public int getY() {
                // текущая координата Y
                return Y;
            }

            public void turnLeft() {
                // повернуться на 90 градусов против часовой стрелки
                switch (dir) {
                    case UP:
                        dir = Direction.LEFT;
                        break;
                    case DOWN:
                        dir = Direction.RIGHT;
                        break;
                    case LEFT:
                        dir = Direction.DOWN;
                        break;
                    case RIGHT:
                        dir = Direction.UP;
                        break;
                }
            }

            public void turnRight() {
                // повернуться на 90 градусов по часовой стрелке
                switch (dir) {
                    case UP:
                        dir = Direction.RIGHT;
                        break;
                    case DOWN:
                        dir = Direction.LEFT;
                        break;
                    case LEFT:
                        dir = Direction.UP;
                        break;
                    case RIGHT:
                        dir = Direction.DOWN;
                        break;
                }

            }

            public void stepForward() {
                // шаг в направлении взгляда
                // за один шаг робот изменяет одну свою координату на единицу
                switch (dir) {
                    case UP:
                        Y++;
                        break;
                    case DOWN:
                        Y--;
                        break;
                    case LEFT:
                        X--;
                        break;
                    case RIGHT:
                        X++;
                        break;
                }

            }
        }

        public static void moveRobot(Robot robot, int toX, int toY) {

            int dirX = robot.getX();
            int dirY = robot.getY();

            //System.out.println("Начальная позиция " + robot.getX() + " " + robot.getY() + ". Направление взгляда: " + robot.getDirection());

            if (dirY >= toY) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnLeft();
                }
                while (dirY != toY) {
                    robot.stepForward();
                    //System.out.println("dirY >= toY " + robot.getX() + " " + robot.getY() + ". Направление взгляда: " + robot.getDirection());
                    dirY--;
                }

            } else {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnRight();
                }
                while (dirY != toY) {
                    robot.stepForward();
                    //System.out.println("dirY <= toY " + robot.getX() + " " + robot.getY() + ". Направление взгляда: " + robot.getDirection());
                    dirY++;
                }
            }
            if (dirX >= toX) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
                while (dirX != toX) {
                    robot.stepForward();
                    //System.out.println("dirX >= toX " + robot.getX() + " " + robot.getY() + ". Направление взгляда: " + robot.getDirection());
                    dirX--;
                }
            } else {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnRight();
                }
                while (dirX != toX) {
                    robot.stepForward();
                    //System.out.println("dirX <= toX " + robot.getX() + " " + robot.getY() + ". Направление взгляда: " + robot.getDirection());
                    dirX++;
                }
            }
        }
}