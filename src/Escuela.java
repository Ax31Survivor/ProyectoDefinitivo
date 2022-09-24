/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelf
 */
public class Escuela {

    String profesor[];
    String institucion[][];
    String materias[][][];
    String alumnos[][][][];

    public Escuela() {
        profesor = null;
        institucion = null;
        materias = null;
        alumnos = null;
    }

    public Escuela(String[] profesor, String[][] institucion, String[][][] materias, String[][][][] alumnos) {
        this.profesor = profesor;
        this.institucion = institucion;
        this.materias = materias;
        this.alumnos = alumnos;
    }

    public String[] getProfesor() {
        return profesor;
    }

    public void setProfesor(String[] profesor) {
        this.profesor = profesor;
    }

    public String[][] getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String[][] institucion) {
        this.institucion = institucion;
    }

    public String[][][] getMaterias() {
        return materias;
    }

    public void setMaterias(String[][][] materias) {
        this.materias = materias;
    }

    public String[][][][] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(String[][][][] alumnos) {
        this.alumnos = alumnos;
    }

    public void defineProfesor(int p) {
        if (p <= 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            profesor = new String[p];
            institucion = new String[p][];
            materias = new String[p][][];
            alumnos = new String[p][][][];
        }
    }

    public void defineInstitucion(int p, int inst) {
        if (inst == 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            if (validaProfesor(p)) {
                institucion = new String[p][inst];
                materias = new String[inst][][];
                alumnos = new String[inst][][][];
            }
        }
    }

    public void defineMateria(int p, int inst, int mat) {
        if (mat <= 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            if (validaInstitucion(p, inst)) {
                materias[p][inst] = new String[mat];
                alumnos[p][inst] = new String[mat][];
            }
        }
    }

    public void defineAlumno(int p, int inst, int mat, int a) {
        if (a <= 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            if (validaMateria(p, inst, mat)) {
                alumnos[p][inst][mat] = new String[a];
            }
        }
    }
    public int i = 0;

    public void cargaProfesor(String aux) {

        profesor[i] = aux;
        i++;
    }

    public void cargaInstitucion(int p, String aux) {   
            institucion[p][0]= aux;
            
    }

    public void cargaMateria(int p, int inst, String... aux) {
        if (validaInstitucion(p, inst)) {
            if (materias[p][inst] == null) {
                materias[p][inst] = aux;
            } else {
                for (int i = 0, j = 0; i < materias[p][inst].length; i++, j++) {
                    if (j >= aux.length) {
                        materias[p][inst][i] = null;
                    } else {
                        materias[p][inst][i] = aux[j];
                    }
                }
            }
        }
    }

    public void cargaAlumno(int p, int inst, int mat, String... aux) {
        if (validaMateria(p, inst, mat)) {
            if (alumnos[p][inst][mat] == null) {
                alumnos[p][inst][mat] = aux;
            } else {
                for (int i = 0, j = 0; i < alumnos[p][inst][mat].length; i++, j++) {
                    if (j >= aux.length) {
                        alumnos[p][inst][mat][i] = null;
                    } else {
                        alumnos[p][inst][mat][i] = aux[j];
                    }
                }
            }
        }
    }

    public boolean validaProfesor(int p) {
        if (profesor != null) {
            return true;
        }
        System.out.println("No se encuentran datos");
        return false;
    }

    public boolean validaInstitucion(int p, int inst) {
        if (!validaProfesor(p)) {
            return false;
        }
        if (institucion.length != 0) {
            return true;
        }
        return false;
    }

    public boolean validaMateria(int p, int inst, int mat) {
        if (validaInstitucion(p, inst)) {
            if (materias[p][inst] != null) {
                if (mat < 0 || mat >= materias[p][inst].length) {
                    System.out.println("Error...No hay datos guardados");
                } else {
                    return true;
                }
            } else {
                System.out.println("No hay datos guardados");
            }
        }
        return false;
    }

    public boolean validaAlumno(int p, int inst, int mat, int a) {
        if (validaMateria(p, inst, mat)) {
            if (alumnos[p][inst][mat] != null) {
                if (a < 0 || a >= alumnos[p][inst][mat].length) {
                    System.out.println("Error...No hay datos guardados");
                } else {
                    return true;
                }
            } else {
                System.out.println("No hay datos guardados");
            }
        }
        return false;
    }

    public void moverAlumno() {

    }

    public void eliminarAlumno() {

    }

    public void eliminarDatos() {

    }

    public String desp() {
        String s = " ";

        if (profesor != null) {
            for (int i = 0; i < profesor.length; i++) {
                s += "profesor " + profesor[i] + "\n";
                if (institucion[i][i] != null) {
                    for (int j = 0; j < institucion.length; j++) {
                        s += "\tinstitucion " + institucion[i][j] + "\n";
                        if (materias[i][j] != null) {
                            for (int k = 0; k < materias.length; k++) {
                                s += "\t\tmateria " + materias[i][j][k] + "\n";
                                if (alumnos[i][j][k] != null) {
                                    for (int l = 0; l < alumnos[i][j][k].length; l++) {
                                        s += "\t\t\talumno " + alumnos[i][j][k][l] + "\n";
                                    }
                                } else {
                                    s += "\t\t\tno hay alumno \n";
                                }
                            }
                        } else {
                            s += "\t\tno hay materia \n";
                        }
                    }
                } else {
                    s += "\tno hay institucion \n";
                }
            }
        } else {
            s += "no hay profesores \n";
        }
        return s;
    }

}
