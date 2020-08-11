package mil.nga.geopackage.tiles.user;

import java.sql.ResultSet;

import mil.nga.geopackage.db.GeoPackageConnection;
import mil.nga.geopackage.user.UserConnection;

/**
 * GeoPackage Tile Connection
 * 
 * @author osbornb
 */
public class TileConnection
		extends UserConnection<TileColumn, TileTable, TileRow, TileResultSet> {

	/**
	 * Constructor
	 * 
	 * @param database
	 *            GeoPackage connection
	 */
	public TileConnection(GeoPackageConnection database) {
		super(database);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected TileResultSet createResult(String[] columns, ResultSet resultSet,
			int count) {
		return new TileResultSet(table, columns, resultSet, count);
	}

	@Override
	public TileResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public TileResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public TileResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public TileResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String selection, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String selection, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String groupBy, String having, String orderBy, String limit) {
		return null;
	}
}
