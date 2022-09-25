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

    static String  profesor[];
   static String institucion[][];
    static String materias[][][];
    static String alumnos[][][][];

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

    public void defineProfesor(int p)
    {
        if (p <= 0)
        {
            System.out.println("Error...No se pueden definir los datos");
        } else
        {
            profesor = new String[p];
            institucion = new String[p][];
            materias = new String[p][][];
            alumnos = new String[p][][][];
        }
    }

    public void defineInstitucion(int p, int inst)
    {

        if (inst == 0)
        {
            System.out.println("Error...No se pueden definir los datos");
        } else
        {
            if (validaProfesor(p))
            {
                institucion = new String[p][inst];
                materias = new String[inst][][];
                alumnos = new String[inst][][][];
            }
        }
    }

    public void defineMateria(int p, int inst, int mat)
    {
        if (mat <= 0)
        {
            System.out.println("Error...No se pueden definir los datos");
        } else
        {
            if (validaInstitucion(p, inst))
            {
                materias = new String[p][inst][mat];
                alumnos = new String[p][inst][mat][];
            }
        }
    }

    public void defineAlumno(int p, int inst, int mat, int a)
    {
        if (a <= 0)
        {
            System.out.println("Error...No se pueden definir los datos");
        } else
        {
            if (validaMateria(p, inst, mat))
            {
                alumnos = new String[p][inst][mat][a];
            }
        }
    }

    public void cargaProfesor(String... aux)
    {
        for (int i = 0; i < aux.length; i++)
        {
            profesor[i] = aux[i];
        }

    }

    public void cargaInstitucion(String... aux)
    {
        for (int i = 0; i < aux.length; i++)
        {
            institucion[0][i] = aux[i];
        }
        for (int i = 0; i < profesor.length; i++)
        {
            institucion[1][i] = profesor[i];
        }
    }

    public void cargaMateria(String... aux)
    {
        for (int i = 0; i < aux.length; i++)
        {
            materias[0][0][i] = aux[i];
        }
        for (int i = 0; i < institucion.length; i++)
        {
            materias[0][1][i] = institucion[0][i];
        }
        for (int i = 0; i < profesor.length; i++)
        {
            materias[1][1][i] = profesor[i];
        }
    }

    public void cargaAlumno(String... aux)
    {
        for (int i = 0; i < aux.length; i++)
        {
            alumnos[0][0][0][i] = aux[i];
        }
        for (int i = 0; i < materias.length; i++)
        {
            alumnos[0][0][1][i] = materias[0][0][i];
        }
        for (int i = 0; i < institucion.length; i++)
        {
            alumnos[0][1][1][i] = institucion[0][i];
        }
        for (int i = 0; i < profesor.length; i++)
        {
            alumnos[1][1][1][i] = profesor[i];
        }
    }

    public boolean validaProfesor(int p)
    {
        String s = null;
        for (int i = 0; i < p; i++)
        {
            if (profesor[i] != null)
            {
                s = profesor[i];
            }
        }
        if (s != null)
        {
            return true;
        }
        System.out.println("No se encuentran datos");
        return false;
    }

    public boolean validaInstitucion(int p, int inst)
    {
        if (!validaProfesor(p))
        {
            return false;
        }
        return true;
    }

    public boolean validaMateria(int p, int inst, int mat)
    {
        if (!validaInstitucion(p, inst))
        {
            return false;
        }
        return true;
    }

    public boolean validaAlumno(int p, int inst, int mat, int a)
    {
        if (validaMateria(p, inst, mat))
        {
            return false;
        }
        return true;
    }

    public void eliminarAlumno() {

    }

    public void eliminarDatos() {

    }

    public String desp()
    {
        String s = " ";
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int p = 0;

        if (profesor == null)
        {
            s += "no hay profesores \n";
            return s;
        } else
        {
            for (i = 0; i < profesor.length; i++)
            {
                s += "profesor " + profesor[i] + "\n";
            }
        }
        if (institucion[0][0] == null)
        {
            s += "\tno hay instituciones \n";
            return s;
        } else
        {
            for (j = 0; j < institucion.length; j++)
            {
                s += "\tinstituciones " + institucion[j][j] + "\n";
            }
        }
        if (materias[0][0][0] == null)
        {
            s += "'t\tno hay materias \n";
            return s;
        } else
        {
            for (int m = 0; m < materias.length; m++)
            {
                s += "\t\tmaterias" + materias[m][m][m] + "\n";
            }
        }
        if (alumnos[0][0][0][0] == null)
        {
            s += "\t\t\tno hay alumnos \n";
            return s;
        } else
        {
            for (int n = 0; n < alumnos.length; n++)
            {
                s += "\t\t\talumnos" + alumnos[n][n][n][n] + "\n";
            }
        } 
        return s;
    }
}