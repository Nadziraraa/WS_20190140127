/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.mahasiswa7.tugas.assesment;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "datamahasiswati")
@NamedQueries({
    @NamedQuery(name = "Datamahasiswati.findAll", query = "SELECT d FROM Datamahasiswati d"),
    @NamedQuery(name = "Datamahasiswati.findByNim", query = "SELECT d FROM Datamahasiswati d WHERE d.nim = :nim"),
    @NamedQuery(name = "Datamahasiswati.findByNama", query = "SELECT d FROM Datamahasiswati d WHERE d.nama = :nama"),
    @NamedQuery(name = "Datamahasiswati.findByJurusan", query = "SELECT d FROM Datamahasiswati d WHERE d.jurusan = :jurusan"),
    @NamedQuery(name = "Datamahasiswati.findByFakultas", query = "SELECT d FROM Datamahasiswati d WHERE d.fakultas = :fakultas"),
    @NamedQuery(name = "Datamahasiswati.findByAlamat", query = "SELECT d FROM Datamahasiswati d WHERE d.alamat = :alamat")})
public class Datamahasiswati implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIM")
    private Long nim;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JURUSAN")
    private String jurusan;
    @Column(name = "FAKULTAS")
    private String fakultas;
    @Column(name = "ALAMAT")
    private String alamat;

    public Datamahasiswati() {
    }

    public Datamahasiswati(Long nim) {
        this.nim = nim;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datamahasiswati)) {
            return false;
        }
        Datamahasiswati other = (Datamahasiswati) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.c.mahasiswa7.tugas.assesment.Datamahasiswati[ nim=" + nim + " ]";
    }
    
}
