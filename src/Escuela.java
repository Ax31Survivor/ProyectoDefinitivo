/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelf
 */
public class Escuela
{

    static String[] profesor;
    static String[][] institucion;
    static String[][][] materias;
    static String[][][][] alumnos;  

    public Escuela()
    {
        profesor = null;
        institucion = null;
        materias = null;
        alumnos = null;
    }

    public Escuela(String[] profesor, String[][] institucion, String[][][] materias, String[][][][] alumnos)
    {
        this.profesor = profesor;
        this.institucion = institucion;
        this.materias = materias;
        this.alumnos = alumnos;
    }

    public String[] getProfesor()
    {
        return profesor;
    }

    public void setProfesor(String[] profesor)
    {
        this.profesor = profesor;
    }

    public String[][] getInstitucion()
    {
        return institucion;
    }

    public void setInstitucion(String[][] institucion)
    {
        this.institucion = institucion;
    }

    public String[][][] getMaterias()
    {
        return materias;
    }

    public void setMaterias(String[][][] materias)
    {
        this.materias = materias;
    }

    public String[][][][] getAlumnos()
    {
        return alumnos;
    }

    public void setAlumnos(String[][][][] alumnos)
    {
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

        if (inst <= 0)
        {
            System.out.println("Error...No se pueden definir los datos");
        } else
        {
            if (validaProfesor(p))
            {
                institucion[p] = new String[inst];
                materias[p] = new String[inst][];
                alumnos[p] = new String[inst][][];
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
                materias[p][inst] = new String[mat];
                alumnos[p][inst] = new String[mat][];
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
                alumnos[p][inst][mat] = new String[a];
            }
        }
    }

    public void cargaProfesor(String... aux)
    {
        System.arraycopy(aux, 0, profesor, 0, aux.length);

    }

    public void cargaInstitucion(String... aux)
    {
        System.arraycopy(aux, 0, institucion[0], 0, aux.length);
        System.arraycopy(profesor, 0, institucion[1], 0, profesor.length);
    }

    public void cargaMateria(String... aux)
    {
        System.arraycopy(aux, 0, materias[0][0], 0, aux.length);
        System.arraycopy(institucion[0], 0, materias[0][1], 0, institucion.length);
        System.arraycopy(profesor, 0, materias[1][1], 0, profesor.length);
    }

    public void cargaAlumno(String... aux)
    {
        System.arraycopy(aux, 0, alumnos[0][0][0], 0, aux.length);
        System.arraycopy(materias[0][0], 0, alumnos[0][0][1], 0, materias.length);
        System.arraycopy(institucion[0], 0, alumnos[0][1][1], 0, institucion.length);
        System.arraycopy(profesor, 0, alumnos[1][1][1], 0, profesor.length);
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
        if (!validaMateria(p, inst, mat))
        {
            return false;
        }
        return true;
    }

    public boolean eliminarAlumno(String s)
    {
        for (int i = 0; i <= alumnos.length; i++)
        {
            if (alumnos[0][0][0][i] == s)
            {
                alumnos[0][0][0][i] = "";
                return true;
            }
        }
        return false;
    }

    public void eliminarDatos()
    {
        for (int i = 0; i <= alumnos.length; i++)
        {
            System.arraycopy(profesor[0], 0, profesor, i, i);
        }

    }

    public void desp()
    {
       for (int i = 0; i < profesor.length; i++)
        {
            System.out.println("Profesor: "+profesor[i]);
            for (int j = 0; j < institucion[i].length; j++)
            {
                System.out.println("\tInstitucion: " + institucion[i][j]);
                for (int k = 0; k < materias[i][j].length; k++)
                {
                    System.out.println("\t\tMateria: " + materias[i][j][k]);
                    for (int l = 0; l < alumnos[i][j][k].length; l++)
                    {
                        System.out.println("\t\t\tAlumno: " + alumnos[i][j][k][l]);
                    }
                }
            }
        }
    }
}
